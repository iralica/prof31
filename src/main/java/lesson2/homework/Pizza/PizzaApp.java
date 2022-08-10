package lesson2.homework.Pizza;

import java.util.ArrayList;
import java.util.List;

import static lesson2.homework.Pizza.PizzaOrder.calcTotalPrice;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza a = new Pizza(PizzaSize.SMALL, 2, 2, 2);
        System.out.println(a);
        a.calcPrice();
        System.out.println("Итого по чеку: " + a.calcPrice());

        List<Pizza> pizzas = new ArrayList<>();
        Pizza Pizza = new Pizza (PizzaSize.LARGE, 2, 2, 0);
        Pizza Pizza1 = new Pizza (PizzaSize.SMALL, 2, 3, 1);
        Pizza Pizza2 = new Pizza(PizzaSize.MEDIUM, 0, 0, 2);
        pizzas.add(Pizza);
        pizzas.add(Pizza1);
        pizzas.add(Pizza2);
        System.out.println(pizzas.size());

        System.out.println(calcTotalPrice(pizzas));
    }
}
