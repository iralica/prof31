package Lesson33_34;

import Lesson23.Rate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lesson34 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD
        // {"amount":10.0,"base":"GBP","date":"2022-11-17","rates":{"USD":11.7965}}
        // берем сумму и вызываем с ней-же вебсервис для перевода USD в EUR

        //CompletableFuture<Rate> u =
        //CompletableFuture.supplyAsync(() -> Request.getRate(10, "GBP", "USD"))
        //        .thenApply(rate -> Request.getRate(rate.rates.get("USD"), "USD", "EUR"));
        CompletableFuture<Rate> u = CompletableFuture.supplyAsync(new Supplier<Rate>() {
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
                });

        System.out.println(u.get());
    }
}
