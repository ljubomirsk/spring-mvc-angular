package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.model.Pizza;

import java.util.List;


public interface OrderService {
    Order placeOrder(Order order);
    Order getOrder(Long id);
    List<Order> listOrders();
    Order updateOrder(Order o);
}
