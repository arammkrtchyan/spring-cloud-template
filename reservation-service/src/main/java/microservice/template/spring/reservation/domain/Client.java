package microservice.template.spring.reservation.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author Aram Mkrtchyan.
 */
@Embeddable
public class Client {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "client_id"))
    private ClientId id;

    Client() {
    }

    public Client(ClientId id) {
        this.id = id;
    }

    public ClientId getId() {
        return id;
    }
}
