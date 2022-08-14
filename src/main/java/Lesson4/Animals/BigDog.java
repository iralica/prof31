package Lesson4.Animals;

public class BigDog extends Animal{
    public BigDog(String name) {
        super(name);
    }

    @Override
    public String greets() {
        return "GAF";
    }

    @Override
    public String greets(Dog another) {
        return "GAFGAF";
    }

    public String greets(BigDog another) {
        return "GAFGAFGAF";
    }
}
