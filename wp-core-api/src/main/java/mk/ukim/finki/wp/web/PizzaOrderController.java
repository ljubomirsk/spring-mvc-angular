package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.model.Pizza;
import mk.ukim.finki.wp.service.impl.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PizzaOrderController {
    @Autowired
    private PizzaOrderService pizzaOrderService;

    @RequestMapping(value = "/create/order", method = RequestMethod.POST)
    public Order createOrder(@RequestBody Order order){
        return pizzaOrderService.placeOrder(order);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable Long id){
        return pizzaOrderService.getOrder(id);
    }

    @RequestMapping(value = "/list/order", method = RequestMethod.GET)
    public List<Order> listOrders(){ return pizzaOrderService.listOrders(); }

    @RequestMapping(value = "/pizza/create", method = RequestMethod.POST)
    public Pizza createPizza(@RequestBody Pizza pizza){ return pizzaOrderService.createPizza(pizza); }

    @RequestMapping(value = "/list/pizza", method = RequestMethod.GET)
    public List<Pizza> listPizzas(){
        return pizzaOrderService.getPizzaTypes();
    }

    @RequestMapping(value = "/pizza/{id}", method = RequestMethod.GET)
    public Pizza getPizza(@PathVariable Long id){ return pizzaOrderService.getPizza(id); }

    @RequestMapping(value = "/pizza/delete/{id}", method = RequestMethod.DELETE)
    public void deletePizza(@PathVariable Long id){ pizzaOrderService.delete(id); }

    @RequestMapping(value = "/update/pizza", method = RequestMethod.POST)
    public Pizza updatePizza(@RequestBody Pizza pizza){ return pizzaOrderService.updatePizza(pizza); }

    @RequestMapping(value = "/order/update/{id}", method = RequestMethod.POST)
    public Order updateOrder(@PathVariable Long id) { return pizzaOrderService.updateOrder(pizzaOrderService.getOrder(id)); }

}
