package microservice.template.spring.reservation.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Aram Mkrtchyan.
 */
@Embeddable
public class ReservationId implements Serializable {


    private String id;

    public ReservationId(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    // JPA stuff

    ReservationId() {
    }

    String getId() {
        return id;
    }
}
