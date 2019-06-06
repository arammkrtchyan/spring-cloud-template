package microservice.template.spring.reservation.application.command;

/**
 * @author Aram Mkrtchyan.
 */
public class DoReservationCommand {

    private String clientId;

    private String seat;

    public DoReservationCommand(String clientId, String seat) {
        this.clientId = clientId;
        this.seat = seat;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSeat() {
        return seat;
    }
}
