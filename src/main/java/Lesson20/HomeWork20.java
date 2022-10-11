package Lesson20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork20 {
    public static void main(String[] args) {
        List<String> count = new ArrayList<>();
        count.add("В двух семьях, равных знатностью и славой,");
        //count.add("В Вероне пышной разгорелся вновь");
        //count.add("Вражды минувших дней раздор кровавый,");
       // count.add("Заставив литься мирных граждан кровь.");
       // count.add("Из чресл враждебных, под звездой злосчастной,");
        //count.add("Любовников чета произошла.");
        //count.add( "По совершенье их судьбы ужасной");
        //count.add( "Вражда отцов с их смертью умерла.");
               // count.add("Весь ход любви их, смерти обречённой,",
                //"И ярый гнев их близких, что угас",
                //"Лишь после гибели четы влюблённой, —",
               // "Часа на два займут, быть может, вас.",
                //        "Коль подарите нас своим вниманьем,",
               // "Изъяны все загладим мы стараньем");
        System.out.println(
                count.stream()
                        .flatMap(line -> Arrays.stream(line.split(" ")))
                        .distinct()
                        .count()
        );
    }
}
