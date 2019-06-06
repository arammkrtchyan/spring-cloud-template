package microservice.template.spring.apigateway.port.adapter.service;

import microservice.template.spring.apigateway.domain.Reservation;

/**
 * @author Aram Mkrtchyan.
 */
class ReservationTranslator {


    Reservation toReservationFromRepresentation(ReservationRepresentation representation) {
        return new Reservation(representation.getClient());
    }

}
