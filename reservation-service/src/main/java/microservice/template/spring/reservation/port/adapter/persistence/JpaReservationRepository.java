package microservice.template.spring.reservation.port.adapter.persistence;

import microservice.template.spring.reservation.domain.Reservation;
import microservice.template.spring.reservation.domain.ReservationId;
import microservice.template.spring.reservation.domain.ReservationRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aram Mkrtchyan.
 */
public interface JpaReservationRepository extends ReservationRepository, JpaRepository<Reservation, ReservationId> {
}
