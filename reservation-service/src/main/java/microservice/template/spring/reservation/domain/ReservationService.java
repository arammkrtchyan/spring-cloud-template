package microservice.template.spring.reservation.domain;

/**
 * @author Aram Mkrtchyan.
 */
public interface ReservationService {

    void changeSeat(Reservation reservation, String newSeat);

}
