package lesson2.homework.Pizza;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza a = new Pizza("small", 2, 2, 2);
        System.out.println(a);
        a.calcPrice();
        System.out.println("Итого по чеку: " + a.calcPrice());
    }
}
