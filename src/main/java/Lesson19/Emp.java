package Lesson19;

public class Emp {
    private String name;
    private int age;
    private String position;

    public Emp(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{" +
                "n='" + name + '\'' +
                ", a=" + age +
                ", p='" + position + '\'' +
                '}';
    }

}
