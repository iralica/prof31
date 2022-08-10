package Lesson3.enums;

public class Pizza {

    private PizzaSize size;
    private String pizza;
    private int cheese;
    private int pepperoni;
    private int ham;

    //public Pizza(String pizzaSize, int cheeseCount, int pepperoniCount, int hamCount)
    public Pizza(PizzaSize size, int cheese, int pepperoni, int ham) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }


    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public int getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(int pepperoni) {
        this.pepperoni = pepperoni;
    }

    public int getHam() {
        return ham;
    }

    public void setHam(int ham) {
        this.ham = ham;
    }

    @Override
    public String toString() {
        return String.format("Вы выбрали: \n %s cheese%2d pepperoni%2d ham%2d", size, cheese, pepperoni, ham);
         }
    public double calcPrice()
    {
        int price = 0;
        switch (size)
        {
            //case "small":
            case SMALL:
                price += 10;
                break;
            //case "medium":
            case MEDIUM:
                price += 12;
                break;
            //case "large":
            case LARGE:
                price += 14;
                break;
        }
        price += (pepperoni + cheese + ham) * 2;
        return price;

    }
}
