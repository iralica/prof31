package lesson2.homework.Pizza;

import static lesson2.homework.Pizza.PizzaSize.*;

public class Pizza {

    private PizzaSize pizzaSize;
    private int cheeseCount;
    private int pepperoniCount;
    private int hamCount;

    public Pizza(PizzaSize pizzaSize, int cheeseCount, int pepperoniCount, int hamCount) {
        this.pizzaSize = pizzaSize;
        this.cheeseCount = cheeseCount;
        this.pepperoniCount = pepperoniCount;
        this.hamCount = hamCount;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public int getCheeseCount() {
        return cheeseCount;
    }

    public void setCheeseCount(int cheeseCount) {
        this.cheeseCount = cheeseCount;
    }

    public int getPepperoniCount() {
        return pepperoniCount;
    }

    public void setPepperoniCount(int pepperoniCount) {
        this.pepperoniCount = pepperoniCount;
    }

    public int getHamCount() {
        return hamCount;
    }

    public void setHamCount(int hamCount) {
        this.hamCount = hamCount;
    }

    @Override
    public String toString() {
        return String.format("Вы выбрали: \n %s cheese%2d pepperoni%2d ham%2d", pizzaSize, cheeseCount, pepperoniCount, hamCount);
         }
    public double calcPrice()
    {
        int price = 0;
        switch (pizzaSize){
            case SMALL:
                price += 10;
                break ;
            case MEDIUM:
                price += 10;
                break ;
            case LARGE:
                price += 10;
                break ;
        }
        price += (pepperoniCount + cheeseCount + hamCount) * 2;
        return price;
        }
    }

