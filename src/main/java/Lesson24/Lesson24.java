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

        Car car1 = new Car("Mitsubishi", "Lancer", 35000);
        Car car2 = new Car("Mitsubishi", "Lancer 1", 36000);
        Car car3 = new Car("BMV", "X5", 55000);
        Car car4 = new Car("BMV", "X6", 85000);
        Car car5 = new Car("Nissan", "GTR", 55000);
        Car car6 = new Car("BMV", "M", 80000);
        List<Car> cars = List.of(car2, car1, car3, car4, car6, car5);
        System.out.println(sortCars(cars));

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
        TreeMap<String, List<Car>> res = new TreeMap<>();
        for (Car car : cars) {
            List<Car> c = res.containsKey(car.getMaker()) ? res.get(car.getMaker()) : new ArrayList<>();
            c.add(car);
            res.put(car.getMaker(), c);
        }
        for (String maker : res.keySet()) {
            List<Car> c = res.get(maker);
            c.sort(Comparator.comparing(Car::getPrice).reversed());
            res.put(maker, c);
        }
        return res;

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


