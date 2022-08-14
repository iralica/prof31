package Lesson4.Animals;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public String greets() {
        return "Meouw";
    }

    @Override
    String greets(Dog another) {
        return null;
    }
}

