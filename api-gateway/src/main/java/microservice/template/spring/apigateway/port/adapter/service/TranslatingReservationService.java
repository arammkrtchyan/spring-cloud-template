package microservice.template.spring.apigateway.port.adapter.service;

import microservice.template.spring.apigateway.domain.Reservation;
import microservice.template.spring.apigateway.domain.ReservationService;
import org.springframework.stereotype.Service;

/**
 * @author Aram Mkrtchyan.
 */
@Service
public class TranslatingReservationService implements ReservationService {

    private ReservationAdapter reservationAdapter;

    public TranslatingReservationService(ReservationAdapter reservationAdapter) {
        this.reservationAdapter = reservationAdapter;
    }

    @Override
    public Reservation byId(String identity) {
        return reservationAdapter.toReservation(identity);
    }

}
