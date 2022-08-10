package Lesson3.enums;

import lesson2.homework.Pizza.PizzaOrder;

public class PizzaTester {
    public static void main(String[] args) {
        Pizza p = new Pizza(PizzaSize.SMALL, 1, 0, 1);

        System.out.println(p);
    }
}