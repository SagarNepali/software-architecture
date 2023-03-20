package esb;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;

public class ShippingRouter {

    public String route(Order order) {
        return order.getAmount() > 175 ? "nextdayshippingchannel" : "normalshippingchannel" ;
    }
}
