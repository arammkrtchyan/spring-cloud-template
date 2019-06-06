package microservice.template.spring.reservation.port.adapter.controller;

/**
 * @author Aram Mkrtchyan.
 */
public class ReservationRepresentation {

    private String client;

    private String seat;

    private String id;

    ReservationRepresentation(String id, String client, String seat) {
        this.client = client;
        this.seat = seat;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getSeat() {
        return seat;
    }

    public String getClient() {
        return client;
    }
}
