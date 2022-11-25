package Lesson31;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                // ��� � ������� run ����������� � ����������� ������
                // ����������� ����� �������� ���� �� ����������� run
                try {
                    Thread.sleep(2_000); // �����������
                } catch (InterruptedException e) {  }
                long threadId = Thread.currentThread().getId();
                System.out.println("hello from thread " + threadId);
            }
        };
        t1.setDaemon(true); // main �� ����� ���������� ��������� ����� ������
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start(); // ������� ����� ����� � ��������� � ��� ����� run


        long mainThreadId = Thread.currentThread().getId();
        System.out.println("hello from main " + mainThreadId);

        // �������� � ��������� 3 ����������� MyThread
        // ������������� ������ � �������� ����� ������� ������� ���� �����������
        IntStream.range(0, 3).forEach(
                i -> new MyThread().start()
        );

        Runnable r1 = new MyRunnable("hello");
       // new Thread(r1).start();
       // new Thread(r1).start();
       // new Thread(r1).start();
       // new Thread(r1).start();

        // ����� ������� + ������� �� Runnable � Callable
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);
        service.submit(r1);


// �������� ���� ����� ����������� Runnable
// ������ ������ run
// ����� ����� ��������� ����� �� 500 ��
// new Random().nextInt(500)
// ����� �������� ������� ����� � ����� ������
// System.currentTimeMillis()

// ��������� 5 ���� �� ExecutorService
// RandomRunnable

        Runnable rr = new RandomRunnable();

        IntStream.range(0, 5).forEach(i -> service.submit(rr));
        service.shutdown(); // ������������� ���������� ���������� ���� ����� � �������
    } // end main
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return null;
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("hello from thread " + threadId);
    }
}



class MyRunnable implements Runnable {
    private String text;
    public MyRunnable(String text)
    {
        this.text =text;
    }
    @Override
    public void run() {
    }
}

class RandomRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("" + System.currentTimeMillis() + " " + Thread.currentThread().getId());
    }

    class RunnableI implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
