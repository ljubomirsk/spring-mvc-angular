package mk.ukim.finki.wp.service.impl;


import mk.ukim.finki.wp.model.*;
import mk.ukim.finki.wp.repository.*;
import mk.ukim.finki.wp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PizzaOrderService implements OrderService,PizzaService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaOrderService(){}

    public List<Pizza> getPizzaTypes(){
        return pizzaRepository.findAll();
    }

    public Pizza createPizza(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public Pizza getPizza(Long id) { return pizzaRepository.getById(id); }

    public void delete(Long id){ pizzaRepository.delete(id); }

    public Pizza updatePizza(Pizza pizza){
        return pizzaRepository.update(pizza);
    }

    public Order placeOrder(Order order){ return orderRepository.save(order); }

    public List<Order> listOrders(){
        return orderRepository.findAll();
    }

    public Order updateOrder(Order o) {
        return orderRepository.update(o);
    }

    public Order getOrder(Long id){ return orderRepository.getById(id); }
}
