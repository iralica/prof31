package Lesson3.enums;

public class Pizza {
    // private String size;
    private PizzaSize size;
    private int cheese, pepperoni, ham;

    //public Pizza(String size, int cheese, int pepperoni, int ham) {
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

    public int calcPrice()
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

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", ham=" + ham +
                '}';
    }
}
