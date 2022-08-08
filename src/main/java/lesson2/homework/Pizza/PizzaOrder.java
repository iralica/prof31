package lesson2.homework.Pizza;


import java.util.ArrayList;
import java.util.List;

public class PizzaOrder{
    public static double calcTotalPrice(List<Pizza> pizzas){
        double summ = 0;
        for (int i = 0; i < pizzas.size(); i++)
            summ += pizzas.get(i).calcPrice();
            return summ;
    }



    //toString
    public static void main(String[] args) {
        List<Pizza> pizzas = new ArrayList<>();
        Pizza Pizza = new Pizza("large", 2, 2, 0);
        Pizza Pizza1 = new Pizza("small", 2, 3, 1);
        Pizza Pizza2 = new Pizza("medium", 0, 0, 2);
        pizzas.add(Pizza);
        pizzas.add(Pizza1);
        pizzas.add(Pizza2);
        System.out.println(pizzas.size());

        System.out.println(calcTotalPrice(pizzas));

    }

}
