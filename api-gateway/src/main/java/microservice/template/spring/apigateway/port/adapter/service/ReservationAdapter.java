package microservice.template.spring.apigateway.port.adapter.service;

import microservice.template.spring.apigateway.domain.Reservation;

/**
 * @author Aram Mkrtchyan.
 */
public interface ReservationAdapter {

    Reservation toReservation(String identity);

}
