package Lesson31;

import java.util.Arrays;

public class SinchroTest {

    public static int[] data = {0};

    private static final Object lock = new Object();

    // ������ � ���� ������� ���� ���������������� �� ������ SynchroTest
    //synchronized public static void add() {
    public static void add() {
        // ���������������� �� ���� lock
        synchronized (lock) {
            int j = data[0];
            j++;
            data[0] = j;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // �������� � ��������� 5 ������� Thread �� ���� MyRunnable
        Runnable r = new MyRunnable();
        // ������������ ���������� ������� data[]
//        IntStream.range(0, 5)
//                .forEach(i -> new Thread(r).start());

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();  // ��������� ��������� ������ � �����
        t2.join();  // ��������� ��������� ������ � �����
        t3.join();  // ��������� ��������� ������ � �����
        t4.join();  // ��������� ��������� ������ � �����
        t5.join();  // ��������� ��������� ������ � �����

        System.out.println(Arrays.toString(data));
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                add();
//                int j = data[0];
//                j++;
//                data[0] = j;
            }
            System.out.println("thread " + Thread.currentThread().getId() + " is finished");
        }
    }
}
