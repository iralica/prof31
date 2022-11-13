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
                // код в функции run выполняется в порожденном потоке
                // порожденный поток работает пока не закончилась run
                try {
                    Thread.sleep(2_000); // милисекунды
                } catch (InterruptedException e) {  }
                long threadId = Thread.currentThread().getId();
                System.out.println("hello from thread " + threadId);
            }
        };
        t1.setDaemon(true); // main не будет дожидаться окончания этого потока
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start(); // создает новый поток и запускает в нем метод run


        long mainThreadId = Thread.currentThread().getId();
        System.out.println("hello from main " + mainThreadId);

        // создайте и запустите 3 экземпляров MyThread
        // тяжеловестная штукаб и занимает много памятиб поэтому быть аккуратными
        IntStream.range(0, 3).forEach(
                i -> new MyThread().start()
        );

        Runnable r1 = new MyRunnable("hello");
       // new Thread(r1).start();
       // new Thread(r1).start();
       // new Thread(r1).start();
       // new Thread(r1).start();

        // набор потоков + очередь из Runnable и Callable
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


// напишите свой класс расширяющий Runnable
// внутри метода run
// будет ждать рандомное время до 500 мс
// new Random().nextInt(500)
// пусть печатает текущее время и номер потока
// System.currentTimeMillis()

// запустите 5 штук на ExecutorService
// RandomRunnable

        Runnable rr = new RandomRunnable();

        IntStream.range(0, 5).forEach(i -> service.submit(rr));
        service.shutdown(); // останавливаем дождавшись выполнения всех задач в очереди
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

}
