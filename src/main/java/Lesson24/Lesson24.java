package Lesson24;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson24 {
    public static void main(String[] args) {
        List<Integer> list = List.of(10,9,8,7,6,5,4,3,2,1,0);
        System.out.println(sumLastN(list, 5)); // 10

        List<Integer> list1 = List.of(2,1,0);
        System.out.println(sumLastN(list1, 5)); // 3

        List<String> months = List.of("january", "february", "march", "june", "march");
        System.out.println(filterList(months, "r")); // {"january", "february", "march"}

        List<String> names = List.of("Max", "Masha", "Daria", "Alex", "Sam");
        System.out.println(getStringLengthFrequency(names)); // {3:2, 4:1, 5:2}


    }
    // Напишите функцию, которая посчитает сумму последних N элементов из
    // передаваемого в нее списка целых
    public static int sumLastN(List<Integer> list, int N)
    {
        int skip = Math.max(list.size() - N, 0);
        return list.stream().skip(skip).reduce(0, Integer::sum);
    }

    // Напишите функцию, которая принимает на вход список строк и строковой шаблон.
    // Возвращает набор не повторяющихся строк, содержащих шаблон
    // до 21:00
    public static Set<String> filterList(List<String> list, String pattern)
    {
        return list.stream().filter(s -> s.contains(pattern)).collect(Collectors.toSet());
    }

    // в функцию передается список строк
    // нужно вернуть Map<Integer, Integer>
    // ключ в которой это длина строки а значение это сколько раз строка такой длины
    // встретилась в списке
    public static Map<Integer, Integer> getStringLengthFrequency(List<String> list)
    {
        Map<Integer, Integer> res = new HashMap<>();
        for(String word: list)
        {
            Integer count = res.get(word.length());
            if(count == null)
                count = 0;
            count++;
            res.put(word.length(), count);
        }
        return res;
    }

    // напишите функцию принимающую список автомобилей и возвращающую 
    // TreeMap<String, List<Car>> где ключ это производитель maker
    // а в списке авмомобили это производителя отсортированные по цене по убыванию
    public static TreeMap<String, List<Car>> sortCars(List<Car> cars)
    {
        for (int i = 0; i < cars.size(); i++) {

        }
    }

}
class Car {
    public String maker;
    public  String model;
    public double price;

    public Car(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ma='" + maker + '\'' +
                ", mod='" + model + '\'' +
                ", pr=" + price +
                '}';
    }
}


