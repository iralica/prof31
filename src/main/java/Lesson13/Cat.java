package Lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Cat {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>(
                Arrays.asList(
                        new Cat(Breed.BURMESE, 18, "Max"),
                        new Cat(Breed.BURMESE, 14, "Alex"),
                        new  Cat(Breed.SIAMESE, 8, "Tikhon")
                )
        );
        cats.sort(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(cats);
        cats.sort(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        System.out.println(cats);
        cats.sort(Comparator.comparing(Cat::getBreed)
                .thenComparing(Cat::getAge)
                .thenComparing(Cat::getName)
        );
        System.out.println(cats);
    }
    public enum Breed {
        SIAMESE, BURMESE, SIBERIAN, SPHINX
    }
    private Breed breed;
    private int age;
    private String name;


    public Cat(Breed breed, int age, String name) {
        this.breed = breed;
        this.age = age;
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "b=" + breed +
                ", a=" + age +
                ", n='" + name + '\'' +
                '}';
    }
}
