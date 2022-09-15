package Lesson13;

import java.util.Comparator;

public class Player implements Comparable<Player>{
    private int rank;
    private String name;
    private int age;

    public Player(int rank, String name, int age) {
        this.rank = rank;
        this.name = name;
        this.age = age;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Comparable это интерфейс, который имплементит класс
    // может быть только одна сортировка по-умолчанию
    // this.compareTo(Player p)

    @Override
    public int compareTo(Player p) {
        //return Integer.compare(age, getAge()); // сортировка по возрасту
        return name.compareTo(p.getName()); // сортировка по имени
    }
    public static class playerAgeComparator implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
