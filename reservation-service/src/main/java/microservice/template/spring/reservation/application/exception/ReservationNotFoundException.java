package microservice.template.spring.reservation.application.exception;

/**
 * @author Aram Mkrtchyan.
 */
public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException() {
    }

    public ReservationNotFoundException(String message) {
        super(message);
    }
}
