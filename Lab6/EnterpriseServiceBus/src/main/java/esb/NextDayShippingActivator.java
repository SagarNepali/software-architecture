package esb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.web.client.RestTemplate;

public class NextDayShippingActivator {

    @Autowired
    RestTemplate restTemplate;

    public void ship(Order order) {
        System.out.println("Next day shipping: "+ order.toString());
        restTemplate.postForLocation("http://localhost:8083/orders", order);
    }
}
