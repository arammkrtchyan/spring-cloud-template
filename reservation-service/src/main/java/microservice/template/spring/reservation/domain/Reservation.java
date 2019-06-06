package microservice.template.spring.reservation.domain;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Aram Mkrtchyan.
 */
@Entity
public class Reservation {

    @EmbeddedId
    private ReservationId id;

    @Embedded
    private Client client;

    private String seat;

    Reservation() {
    }

    public static Reservation reserve(Client client, String seat) {
        // Raise domain event instead.
        return new Reservation(client, seat);
    }

    private Reservation(Client client, String seat) {
        this(new ReservationId(UUID.randomUUID().toString()),
                client, seat);
    }

    private Reservation(
            ReservationId id,
            Client client,
            String seat) {
        this.id = id;
        this.seat = seat;
        this.client = client;
    }

    public String getSeat() {
        return seat;
    }

    public ReservationId getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

}
