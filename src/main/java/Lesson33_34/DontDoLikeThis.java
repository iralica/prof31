package Lesson33_34;

import Lesson23.Rate;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class DontDoLikeThis {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                Rate rate = Request.getRate(10, "GBP", "USD");
                startNewThread(rate);
            }
        }.start();
    }

    private static void startNewThread(Rate rate) {
        /*CompletableFuture<Rate> u = CompletableFuture.supplyAsync(new Supplier<Rate>() {
                    @Override
                    public Rate get() {
                        return Request.getRate(10, "GBP", "USD");
                    }
                })
                .thenApplyAsync(new Function<Rate, Rate>() {
                    @Override
                    public Rate apply(Rate rate) {
                        return Request.getRate(rate.rates.get("USD"), "USD", "EUR");
                    }
                }).handle(new BiFunction<Rate, Throwable, Rate>() {
                    @Override
                    public Rate apply(Rate rate, Throwable throwable) {
                        if(throwable != null)
                            System.out.println(throwable.getMessage());
                        return rate;
                    }
                });
        CompletableFuture<Rate> u =
                CompletableFuture.supplyAsync(() -> Request.getRate(10, "GBP", "USD"))
                        .thenApply(rate -> Request.getRate(rate.rates.get("USD"), "USD", "EUR"))
                        .handle((r,t) -> { if(t != null) System.out.println(t); return r ;     } );
*/
    }
}
