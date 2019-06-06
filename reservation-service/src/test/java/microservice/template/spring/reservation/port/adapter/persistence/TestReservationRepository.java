package microservice.template.spring.reservation.port.adapter.persistence;

import microservice.template.spring.reservation.application.ReservationApplicationService;
import microservice.template.spring.reservation.domain.Client;
import microservice.template.spring.reservation.domain.ClientId;
import microservice.template.spring.reservation.domain.Reservation;
import microservice.template.spring.reservation.domain.ReservationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Random;

/**
 * @author Aram Mkrtchyan.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Import(ReservationApplicationService.class)
public class TestReservationRepository {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void testFindById() {
        String testClient = "test";
        String seatNumber = String.valueOf(new Random().nextInt(10));
        Reservation reservation = Reservation.reserve(new Client(ClientId.fromExisting(testClient)), seatNumber);
        testEntityManager.persist(reservation);
        testEntityManager.flush();

        Optional<Reservation> persisted = reservationRepository.findById(reservation.getId());

        Assert.assertTrue(persisted.isPresent());
        Assert.assertEquals(testClient, persisted.get().getClient().getId().id());
        Assert.assertEquals(seatNumber, persisted.get().getSeat());

    }

}
