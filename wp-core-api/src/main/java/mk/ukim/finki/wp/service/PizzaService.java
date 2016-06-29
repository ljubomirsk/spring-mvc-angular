package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Pizza;

import java.util.List;

public interface PizzaService {
    List<Pizza> getPizzaTypes();
    Pizza createPizza(Pizza pizza);
    Pizza getPizza(Long id);
    void delete(Long id);
    //Pizza updatePizza(Pizza pizza);
}
