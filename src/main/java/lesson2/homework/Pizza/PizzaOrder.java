package lesson2.homework.Pizza;


import java.util.ArrayList;
import java.util.List;

public class PizzaOrder{
    private List<Pizza> pizzas = new ArrayList<>();


    public static double calcTotalPrice(List<Pizza> pizzas){
        double summ = 0;
        for (int i = 0; i < pizzas.size(); i++)
           // Pizza p = pizzas.get(i);      как вариант
           // summ += calcTotalPrice(p);
            summ += pizzas.get(i).calcPrice();
            return summ;
    }


    /*public void add(Pizza Pizza) {
        pizzas.add(pizza);

    }*/


}
