package lesson2.homework.Pizza;

public class Pizza {

    private String pizzaSize;
    private int cheeseCount;
    private int pepperoniCount;
    private int hamCount;

    public Pizza(String pizzaSize, int cheeseCount, int pepperoniCount, int hamCount) {
        this.pizzaSize = pizzaSize;
        this.cheeseCount = cheeseCount;
        this.pepperoniCount = pepperoniCount;
        this.hamCount = hamCount;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
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
        if(pizzaSize.equalsIgnoreCase("small"))
        {
            return  10 + (cheeseCount + pepperoniCount + hamCount) * 2;
        }
        else if(pizzaSize.equalsIgnoreCase("medium"))
        {
            return 12 + (cheeseCount + pepperoniCount + hamCount) * 2;
        }
        else if(pizzaSize.equalsIgnoreCase("large"))
        {
            return 14 + (cheeseCount + pepperoniCount + hamCount) * 2;
        }
        else
        {
            return  0.00;
        }
    }
}
