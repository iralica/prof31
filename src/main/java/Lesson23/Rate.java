package Lesson23;

import java.util.HashMap;
import java.util.Map;

public class Rate {
    public double amount;
    public String base;
    public String date;

    public Map<String, Double> rates = new HashMap<>();
    // {"amount":10.0,"base":"GBP","date":"2022-11-17","rates":{"USD":11.7965}}
    @Override
    public String toString() {
        return "Rate{" +
                "amount=" + amount +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", rates=" + rates +
                '}';
    }

}
