package microservice.template.spring.reservation.domain;

import java.util.Optional;

/**
 * @author Aram Mkrtchyan.
 */
public interface ReservationRepository {

    Iterable<Reservation> findAll();

    Optional<Reservation> findById(ReservationId reservationId);

    Reservation save(Reservation reservation);

}
