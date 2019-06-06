package microservice.template.spring.apigateway.domain;

/**
 * @author Aram Mkrtchyan.
 */
public class Reservation {

    private String client;

    public Reservation(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }
}
