package esb;

public class OrderTypeRouter {

    public String orderType(Order order) {
        return order.getOrderType().equals(Order.OrderType.DOMESTIC) ? "domesticshippingchannel" : "internationalshippingchannel" ;
    }
}
