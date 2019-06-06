package microservice.template.spring.reservation;

import microservice.template.spring.reservation.application.ReservationApplicationService;
import microservice.template.spring.reservation.application.command.DoReservationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class ReservationServiceApplication {

    private final ReservationApplicationService reservationService;

    @Autowired
    public ReservationServiceApplication(ReservationApplicationService reservationService) {
        this.reservationService = reservationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ReservationApplicationService reservationService) {
        return strings -> {
            Stream.of("Josh", "Pieter", "Tasha", "Eric", "Susie", "Max")
                    .forEach(clientId -> reservationService.reserveFor(
                            new DoReservationCommand(
                                    clientId,
                                    String.valueOf(new Random().nextInt(100))
                            )
                    ));
        };
    }

}
