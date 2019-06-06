package microservice.template.spring.reservation.application;

import microservice.template.spring.reservation.application.command.DoReservationCommand;
import microservice.template.spring.reservation.domain.Reservation;
import microservice.template.spring.reservation.domain.ReservationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
//@ComponentScan("microservice.template.spring.reservation")
@Import(ReservationApplicationService.class)
public class TestReservationApplicationService {

    @Autowired
    private ReservationApplicationService reservationApplicationService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void testReservationFor() {
        String client = "TEST";
        String seat = String.valueOf(new Random().nextInt(100));
        DoReservationCommand command = new DoReservationCommand(client, seat);
        Reservation reservation = reservationApplicationService.reserveFor(command);

        Optional<Reservation> afterReservation = reservationRepository.findById(reservation.getId());
        Assert.assertTrue(afterReservation.isPresent());
        Assert.assertEquals(seat, afterReservation.get().getSeat());
    }


}
