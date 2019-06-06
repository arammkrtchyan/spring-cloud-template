package microservice.template.spring.reservation.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Aram Mkrtchyan.
 */
@Embeddable
public class ClientId implements Serializable {

    private String id;

    public static ClientId fromExisting(String id) {
        return new ClientId(id);
    }

    private ClientId(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }


    // JPA stuff

    ClientId() {
    }

    String getId() {
        return id;
    }
}
