package Lesson24.HomeWork;


import retrofit2.http.Path;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.UserPrincipal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Car1 {
    public Car1(String peugeot, String s, int i) {
    }

    public static void main(String[] args) {

        Car car1 = new Car("Mitsubishi", "Lancer", 35000);
        Car car2 = new Car("Mitsubishi", "Lancer 1", 36000);
        Car car3 = new Car("BMV", "X5", 55000);
        Car car4 = new Car("BMV", "X6", 85000);
        Car car5 = new Car("Nissan", "GTR", 55000);
        Car car6 = new Car("BMV", "M", 80000);
        List<Car> cars = List.of(car2, car1, car3, car4, car6, car5);
        out.println(sortCars(cars));
    }
    public static TreeMap<String, List<Car>> sortCars(List<Car> cars){ // превратив это из TreeMap в список машин List<Car>
        TreeMap<String, List<Car>> res = cars.stream().
                // группируем по производителю
                collect(Collectors.groupingBy(Car::getMaker))
                   // создать новый набор и сохранить в нем элементы карты (сгруперованные машины)
                  .entrySet()
                      // по этим сеттам запустить еще один стреам
                    .stream()
                          // мы указываем стратегию получения ключа и значения для карты
                       .collect(Collectors.toMap(
                               //
                               Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, TreeMap::new));                  //
        res.forEach((key, value) -> value.sort(Comparator.comparing(Car::getPrice)));      //
        return res;
    }
   /* private static void dir(String d) throws IOException {
        File dir = new File(d);
        String dirAbsPath = dir.getAbsolutePath(); // полный путь к директории
        String sep = File.separator;
        String [] files = dir.list();
        for(int i = 0; i < files.length; i++)
        {
            String name = files[i];
            Path path = Path.of(dirAbsPath + sep + name);
            UserPrincipal user = Files.getOwner(path);
            out.print(
                    Files.isDirectory(path) ? "d" : "-"
            );
            out.print(
                    Files.isReadable(path) ? "r" : "-"
            );
            out.print(
                    Files.isWritable(path) ? "w" : "-"
            );
            out.print(
                    Files.isExecutable(path) ? "x" : "-"
            );
            out.printf(" %15s %10d %30s\n", user.getName(), Files.size(path), name);
        }
    }*/



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

