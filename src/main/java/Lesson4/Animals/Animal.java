package Lesson4.Animals;

abstract public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract String greets();


    abstract String greets(Dog another);
}
