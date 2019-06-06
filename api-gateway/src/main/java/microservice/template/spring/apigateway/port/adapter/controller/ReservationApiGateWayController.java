package microservice.template.spring.apigateway.port.adapter.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import microservice.template.spring.apigateway.domain.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aram Mkrtchyan.
 */
@RestController
@RequestMapping("reservations")
public class ReservationApiGateWayController {

    private final ReservationService reservationService;


    @Autowired
    public ReservationApiGateWayController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @HystrixCommand(fallbackMethod = "getDefaultClient")
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String client(@PathVariable String id) {
        return reservationService.byId(id).getClient();
    }

    private String getDefaultClient(String id) {
        return "unknown";
    }
}
