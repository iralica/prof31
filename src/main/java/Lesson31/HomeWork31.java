package Lesson31;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class HomeWork31 {
    // �� ���� ���:
// 1. ** ��������� ������������ ����� pi, ���������� ����:
// �������� ��� ����� �������� - ���� ��� �����,
// ��� ������� ����������� ���������� �� ������ ��������� R ������  1.0 ("yes" �������)
// � ������ ������� ��� ��� �����, ��� ������� ����������� ���������� �� ������ ��������� R ������ 1.0
// �������� ����������� �� Runnable ����� � ������ run ������ ��������:
// - ������������ � ������� ���������� ��������� ����� ��� double �����
// �� ��������� [0.0 - 1.0] - x � y ���������� �����;
// - � ������� ������� ��������, ��������� ��� ��� ���������� �� ������ ��������� - R;
// - ���� ��� ��������������� ����� ���������� R �� ������ ��������� ������ 1.0,
// �� ������������ �� ������� ������� "yes"; ���� R ������ 1.0 ������������ �� ������� ������� "no";
// - �������� � ��������� 1_000_000 ����� Runnable ����� ExecutorService;
// - �� ����������� ������������ ��������� �������� pi ��� 4.0*yes/(yes+no).

// 2. *** ������������������� � ����������� ������� � ExecutrorService -
// ��� ����� �� ��������� ���������� ���������� �������� ������������ ������ �������?

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
        long before = System.currentTimeMillis(); // ����� ����������� � 1 ������ 1970�.

        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        IntStream.range(0, 1_000_000)
                .forEach(
                        i -> service.submit(new PiRunnable())
                );

        // ������������� ������ ����� ����� ���� ��� � ���� ��������� ��������� Runnable
        service.shutdown();

        try {
            service.awaitTermination(2_000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis(); // ����� ����������� � 1 ������ 1970�.

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
