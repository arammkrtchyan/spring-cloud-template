package microservice.template.spring.reservation.port.adapter.controller;

import microservice.template.spring.reservation.application.ReservationApplicationService;
import microservice.template.spring.reservation.domain.Reservation;
import microservice.template.spring.reservation.domain.ReservationId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Aram Mkrtchyan.
 */
@RestController
public class ReservationController {

    private ReservationApplicationService reservationService;

    public ReservationController(ReservationApplicationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<ReservationRepresentation> all() {
        return StreamSupport.stream(
                reservationService.all().spliterator(), false).map(reservation ->
                new ReservationRepresentation(
                        reservation.getId().id(),
                        reservation.getClient().getId().id(),
                        reservation.getSeat()
                )).collect(Collectors.toList());

    }

    @RequestMapping(path = "/reservations/{reservationId}", method = RequestMethod.GET)
    public ReservationRepresentation getReservation(@PathVariable String reservationId) {
        Reservation reservation = reservationService.reservation(new ReservationId(reservationId));
        return new ReservationRepresentation(
                reservation.getId().id(),
                reservation.getClient().getId().id(),
                reservation.getSeat()
        );
    }
}
