package Lesson21;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class StudentTester {
    public static void main(String[] args) {
        //JavaStreams Collectors and custom Collectors
        // Collector - сгруппировать, разделить, обсчитать или сохранить в коллекцию элементы потока
        // collect() - терминальная операция потока

        // Collectors - типы
        //      Partition - передаем предикат и поток делится на две группы - удовлетворяющие предикату и нет
        //      Grouping - передаем две функции для создания ключей и значений - на выходе Map
        //      Reducing - вычисление какого-то значения по всем элементам потока
        //      Collection - создание коллекции на базе потока
        List<Student> students = List.of(
                new Student("Michaeli", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobisheva", 19),
                new Student("Max", "Palov", 24)
        );
        //List
        System.out.println(
                students.stream().filter(s -> s.getLastName()
                                .toLowerCase().contains("s"))
                        .collect(Collectors.toList())); //ArrayList

        Collection<String> c =
                students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                        .map(Student::getLastName)
                        .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(c);

        students.stream()
                .map(Student::getLastName)
                .collect(Collectors.toUnmodifiableList()); //RO List

        //Set
        students.stream()
                .map(Student::getLastName)
                .collect(Collectors.toSet());

        //TreeSet
        students.stream()
                .map(Student::getLastName)
                .collect(Collectors.toCollection(TreeSet::new));

        //Map
        students.stream()
                .collect(Collectors.groupingBy(Student::getAge));


        students.stream()
                .collect(Collectors.toMap( //Map<String, Student>
                        s -> s.getLastName() + " " + s.getFirstName(),
                        Function.identity()
                        ));
        // Collectors.toUnmodifiableMap() //Ro Map

        //String
        System.out.println(
                students.stream()
                .map(Student::getLastName)
                .collect(Collectors.joining(", ", "<", ">"))
        );

        // Числовая статистика
        IntSummaryStatistics intSummaryStatistics =
                students.stream()
                        .collect(Collectors.summarizingInt(s -> s.getAge()));
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());

        students.stream()
                .collect(Collectors.counting());// количество


        students.stream()
                .collect(Collectors.summarizingInt(Student::getAge));// сумма возрастов

        Optional<Student> maxStudent =
                students.stream()
                        .collect(Collectors.maxBy(
                                Comparator.comparing(Student::getLastName)
                        ));
        //Collectors.minBy

        //Partition
        Map<Boolean, List<Student>> studentPartition =
                students.stream()
                        .collect(
                                Collectors.partitioningBy(s -> s.getLastName().endsWith("a"))
                        );
        System.out.println(studentPartition);

        // для studentPartition посчитать сумму возрастов мужчин и женщин
        studentPartition.values().stream()
                .map(
                studentList -> studentList.stream()
                        .collect(Collectors.summarizingInt(Student::getAge)).getSum())
                .forEach(System.out::println);

        studentPartition.values().stream()
                .map(studentList -> studentList.stream().collect(Collectors.summarizingInt(Student::getAge)).getSum())
                .forEach(System.out::println);

        Map<Integer, List<Student>> studentByAge =
        students.stream()
                .collect(Collectors.groupingBy(Student::getAge)
                        );

        Map<Integer, Set<Student>> studentsByAgeSet =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getAge, Collectors.toSet()));

        // studentsByAge
        // распечатайте возраст и количество студентов в каждом возрасте
        // studentsByAge.entrySet().stream()
        studentByAge.forEach(
                (age, students1) -> System.out.println(age + ":" + students1.size())
        );



        // Custom Collector
        // interface Collector<T, A, R>
        // T - тип того что коллектор обрабатывает, например, Student
        // A - тип аккумулятора - коллекция куда студенты записываются либо для возвращения либо для
        // дальнейшей обработки
        // R - тип возвращаемого значения - например, коллекция List<Student> либо какая-то статистика -
        // Double если нужно посчитать средний возраст

        // supplier() должен возвратить Supplier который создаст тип возвращаемого значения (коллекцию) в которую потом
        // accumulator будет добавлять значения из потока


        Map<Integer, List<Student>> customStudentsByAge =
                students.stream()
                        .collect(new Collector<Student, Map<Integer, List<Student>>, Map<Integer, List<Student>>>() {
                            @Override
                            public Supplier<Map<Integer, List<Student>>> supplier() {
                                return new Supplier<Map<Integer, List<Student>>>() {
                                    @Override
                                    public Map<Integer, List<Student>> get() {
                                        return new HashMap<>(); // создаем мапу в которой будут накапливаться студенты
                                    }
                                };
                            }

                            @Override
                            public BiConsumer<Map<Integer, List<Student>>, Student> accumulator() {
                                return (map, student) -> {
                                    // получить из student ключ
                                    int age = student.getAge();
                                    // посмотреть, есть ли в map список студентов с таким возрастом
                                    // если его нет, то создать этот список
                                    List<Student> studs = map.containsKey(age) ? map.get(age) : new ArrayList<>();
                                    // добавить в список студента
                                    studs.add(student);
                                    // по ключу-возрасту сохранить в map список со студентами нужного возраста
                                    map.put(age, studs);
                                };
                            }

                            @Override
                            public BinaryOperator<Map<Integer, List<Student>>> combiner() {
                                return (f, s) -> null;
                            }

                            @Override
                            public Function<Map<Integer, List<Student>>, Map<Integer, List<Student>>> finisher() {
                                return new Function<Map<Integer, List<Student>>, Map<Integer, List<Student>>>() {
                                    @Override
                                    public Map<Integer, List<Student>> apply(Map<Integer, List<Student>> map) {
                                        return map;
                                    }
                                };
                            }
                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);
                            }
                        });
        System.out.println(customStudentsByAge);

        // Коллектор который вернет максимальное количество людей в одном возрасте
        int maxNumberOfStudentsInAge =
                students.stream()
                        .collect(new Collector<Student, Map<Integer, List<Student>>, Integer>() {
                            @Override
                            public Supplier<Map<Integer, List<Student>>> supplier() {
                                return HashMap::new;
                            }

                            @Override
                            public BiConsumer<Map<Integer, List<Student>>, Student> accumulator() {
                                return (map, student) -> {
                                    // получить из student ключ
                                    int age = student.getAge();
                                    // посмотреть, есть ли в map список студентов с таким возрастом
                                    // если его нет, то создать этот список
                                    List<Student> studs = map.containsKey(age) ? map.get(age) : new ArrayList<>();
                                    // добавить в список студента
                                    studs.add(student);
                                    // по ключу-возрасту сохранить в map список со студентами нужного возраста
                                    map.put(age, studs);
                                };
                            }

                            @Override
                            public BinaryOperator<Map<Integer, List<Student>>> combiner() {
                                return (f, s) -> null;
                            }

                            @Override
                            public Function<Map<Integer, List<Student>>, Integer> finisher() {
                                return new Function<Map<Integer, List<Student>>, Integer>() {
                                    @Override
                                    public Integer apply(Map<Integer, List<Student>> map) {
                                        return map.values().stream()
                                                .map(Collection::size)
                                                .max(Comparator.naturalOrder())
                                                .orElse(0);
                                    }
                                };
                            }


                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED);
                            }
                        });
        System.out.println(maxNumberOfStudentsInAge);




    }
}
