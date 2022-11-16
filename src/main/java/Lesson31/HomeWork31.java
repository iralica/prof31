package Lesson31;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class HomeWork31 {
    // ДЗ проф ява:
// 1. ** Вычислите многопоточно число pi, инструкции ниже:
// Заведите два целых счетчика - один для точек,
// для которых вычисленное расстояние до начала координат R меньше  1.0 ("yes" счетчик)
// и второй счетчик для тех точек, для которых вычисленное расстояние до начала координат R больше 1.0
// Создайте производный от Runnable класс и внутри run метода напишите:
// - сгенерируйте с помощью генератора случайных чисел два double числа
// из диапазона [0.0 - 1.0] - x и y координаты точки;
// - с помощью теоремы Пифагора, вычислите для нее расстояние от начала координат - R;
// - если для сгенерированной точки расстояние R до начала координат меньше 1.0,
// то увеличивайте на единицу счетчик "yes"; если R больше 1.0 увеличивайте на единицу счетчик "no";
// - создайте и запустите 1_000_000 таких Runnable через ExecutorService;
// - по результатам эксперимента вычислите значение pi как 4.0*yes/(yes+no).

// 2. *** поэкспериментируйте с количеством потоков в ExecutrorService -
// при каком их примерном количестве вычисление занимает сравнительно меньше времени?

    // https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html

    private static int yes = 0;
    private static int no = 0;
    private static Random random = new Random();
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        runner(2);
        yes = 0;
        no = 0;
        runner(5);
        yes = 0;
        no = 0;
        runner(10);
        yes = 0;
        no = 0;
        runner(20);
        yes = 0;
        no = 0;
        runner(40);
        yes = 0;
        no = 0;
        runner(100);
        yes = 0;
        no = 0;
        runner(500);
        yes = 0;
        no = 0;
        runner(1000);
}
    private synchronized static void addYes() {
        yes++;
    }

    private synchronized static void addNo() {
        no++;
    }

    static void runner(int numberOfThreads) {
        long before = System.currentTimeMillis(); // число миллисекунд с 1 января 1970г.

        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        IntStream.range(0, 1_000_000)
                .forEach(
                        i -> service.submit(new PiRunnable())
                );

        // останавливает сервис сразу после того как в него отправлен последний Runnable
        service.shutdown();

        try {
            service.awaitTermination(2_000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis(); // число миллисекунд с 1 января 1970г.

        System.out.println("Threads number: " + numberOfThreads +
                "pi: " + 4.0 * yes / (yes + no) +
                " yes: " + yes +
                " no: " + no +
                " sum: " + (yes + no) +
                " time: " + (after - before));
    }
    static class PiRunnable implements Runnable {
        @Override
        public void run() {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1) {
                addYes();
            } else {
                addNo();
            }
        }
    }
}
