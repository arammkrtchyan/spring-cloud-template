package microservice.template.spring.apigateway.port.adapter.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Aram Mkrtchyan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ReservationRepresentation {

    private String client;

    @JsonCreator
    public ReservationRepresentation(
            @JsonProperty(value = "client") String client) {
        this.client = client;
    }

    String getClient() {
        return client;
    }
}
