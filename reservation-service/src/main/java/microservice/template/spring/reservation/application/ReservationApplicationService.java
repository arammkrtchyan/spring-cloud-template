package microservice.template.spring.reservation.application;

import microservice.template.spring.reservation.application.command.DoReservationCommand;
import microservice.template.spring.reservation.application.exception.ReservationNotFoundException;
import microservice.template.spring.reservation.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Aram Mkrtchyan.
 */
@Service
public class ReservationApplicationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationApplicationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation reserveFor(DoReservationCommand command) {
        Reservation reservation = Reservation.reserve(
                new Client(ClientId.fromExisting(command.getClientId())),
                command.getSeat()
        );
        return reservationRepository.save(reservation);
    }

    public Reservation reservation(ReservationId reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow(() ->
                new ReservationNotFoundException(String.format("No reservation %s", reservationId))
        );
    }

    public Iterable<Reservation> all() {
        return reservationRepository.findAll();
    }

}
