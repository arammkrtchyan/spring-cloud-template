package microservice.template.spring.reservation.port.adapter.controller;

import microservice.template.spring.reservation.application.ReservationApplicationService;
import microservice.template.spring.reservation.domain.Client;
import microservice.template.spring.reservation.domain.ClientId;
import microservice.template.spring.reservation.domain.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Aram Mkrtchyan.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class TestReservationController {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationApplicationService service;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {

        String client = "TEST";
        String seat = String.valueOf(new Random().nextInt(100));

        Reservation reservation = Reservation.reserve(new Client(ClientId.fromExisting(client)), seat);

        List<Reservation> reservations = Collections.singletonList(reservation);

        given(service.all()).willReturn(reservations);

        mvc.perform(get("/reservations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].seat", is(reservation.getSeat())))
                .andExpect(jsonPath("$[0].client", is(reservation.getClient().getId().id())));
        ;
    }

}
