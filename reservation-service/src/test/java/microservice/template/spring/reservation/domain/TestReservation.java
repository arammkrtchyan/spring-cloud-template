package microservice.template.spring.reservation.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aram Mkrtchyan.
 */
public class TestReservation {

    @Test
    public void testReservation() {
        String testClientId = "client_id";
        String testSeat = "12";

        Client client = new Client(ClientId.fromExisting(testClientId));

        Reservation reservation = Reservation.reserve(client, testSeat);

        Assert.assertEquals(reservation.getSeat(), testSeat);
        Assert.assertEquals(reservation.getClient().getId().id(), testClientId);

        Assert.assertNotNull(reservation.getId());
    }

}
