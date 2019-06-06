package microservice.template.spring.apigateway.port.adapter.service;

import microservice.template.spring.apigateway.domain.Reservation;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Aram Mkrtchyan.
 */
@Component
public class HttpReservationAdapter implements ReservationAdapter {

    private RestTemplate restTemplate;

    private ReservationTranslator reservationTranslator = new ReservationTranslator();

    public HttpReservationAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Reservation toReservation(String identity) {
        ReservationRepresentation representation = restTemplate.getForEntity(
                "http://reservation-service/reservations/{identity}",
                ReservationRepresentation.class,
                identity
        ).getBody();
        return reservationTranslator.toReservationFromRepresentation(representation);
    }

}
