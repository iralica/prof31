package Lesson19;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmpTester {
    public static void main(String[] args) {
        List<Emp> employees = List.of(
                new Emp("Max Petrov", 22, "programmer"),
                new Emp("Ivan Shapovalov", 33, "analyst"),
                new Emp("Semen Dezhnev", 55, "manager"),
                new Emp("Oleg Petrov", 19, "intern"),
                new Emp("Katerina Drogova", 31, "programmer"),
                new Emp("Nikolas Spivakov", 23, "analyst"),
                new Emp("Boris Moiseev", 48, "manager"),
                new Emp("Petr Sveshnikov", 37, "programmer"),
                new Emp("Alex Con", 33, "analyst"),
                new Emp("Olga Filimonova", 27, "programmer")

        );

        employees.stream()
                .min(Comparator.comparing(Emp::getAge))
                .ifPresent(System.out::println);

        employees.stream()
                .map(emp -> emp.getName())
                .forEach(System.out::println);

        // распечатать всех с возрастом больше 41
        employees.stream()
                .filter(emp -> emp.getAge()>41)
                .forEach(System.out::println);

        // распечатать всех работников отсортировав их по профессии и возрасту
        employees.stream()
                .sorted(Comparator.comparing(Emp::getPosition).thenComparing(Comparator.comparing(Emp::getAge)))
                .forEach(System.out::println);

        // заджойнить имена всех работников старше 36 лет через ", "
        employees.stream()
                .filter(emp -> emp.getAge()>36)
                        .map((Function<Emp, Object>) emp -> "," + emp.getName())
                            .forEach(System.out::println);

        System.out.println(
                employees.stream()
                        .filter(emp -> emp.getAge() > 36)
                        .map(Emp::getName)
                        .map(n -> n.split(" "))
                        .map(array -> array[0])
                        .collect(Collectors.joining(", "))
        );

        // посчитайте сумму возрастов работников
        int summOfAge = employees.stream()
                .mapToInt(Emp::getAge).sum();
        System.out.println(summOfAge);

        System.out.println(
                employees.stream()
                        .map(Emp::getAge)
                        .reduce(0, Integer::sum)
        );

        // посчитайте количество программистов
        long count = employees.stream()
                          .filter(emp -> "programmer".equals(emp.getPosition()) )
                                .count();
        System.out.println(count);

        System.out.println(
                employees.stream()
                        .filter(e -> e.getPosition().equals("programmer"))
                        .count()
        );

        // посчитайте средний возраст
        OptionalDouble averageAge = employees.stream()
                .mapToInt(emp-> emp.getAge())
                .average();
        System.out.println(averageAge);

        // разделите на две группы - старше 40 лет и младше
        // найдите профессию самого "старого" из "молодых"

       Map<Boolean, List<Emp>> oldYoung = employees.stream()
               .collect(Collectors.partitioningBy(emp -> emp.getAge() > 40));
        System.out.println(oldYoung);

        oldYoung.get(false)
                .stream()
                .max(Comparator.comparing(Emp::getAge))
                .map(Emp::getPosition)
                .ifPresent(System.out::println);

        // сгруппируйте по профессии
         Map<String, List<Emp>> pos = employees.stream()
                 .collect(Collectors.groupingBy(Emp::getPosition));
         System.out.println(pos);

        // распечатать профессии и количество работников в ней
        Map<String, Long> countProfEmp =
                employees.stream()
                        .collect(Collectors.groupingBy(Emp::getPosition, Collectors.counting()));
        System.out.println(countProfEmp);

        //countProfEmp
        //        .entrySet().stream()
         //       .forEach(
         //               entry -> System.out.println(entry.getKey() + ":" + entry.getValue().size())
         //       );


        // вернуть средний возраст мужчин и женщин - у женщин фамилия оканчивается на "a"
        employees.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(e.getName().length() - 1) == 'a'))
                    .forEach((key, value) ->
                            System.out.println
                                    (value.stream()
                                            .mapToInt(Emp::getAge).average()));

        // распечатать работников с самым часто встречающимся возрастом
        Map<Integer, Long> countOffenAge =
                employees.stream()
                        .collect(Collectors.groupingBy(Emp::getAge, Collectors.counting()));

        System.out.println(countOffenAge);

        employees.stream()
                .collect(Collectors.groupingBy(Emp::getAge))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().size() - o1.getValue().size())
                .limit(1)
                .map(Map.Entry::getValue)
                .forEach(
                        System.out::println
                );

    }

}
