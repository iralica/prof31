package Lesson4.Animals;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public String greets() {
        return "Gaf";
    }

    public String greets(Dog another)
    {
        return "GafGaf";
    }
}
