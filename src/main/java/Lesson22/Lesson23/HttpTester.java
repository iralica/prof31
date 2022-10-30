package Lesson22.Lesson23;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTester {
    public static void main(String[] args) throws IOException {
        // https://api.frankfurter.app/
        URL url = new URL("https://api.frankfurter.app/latest?amount=10&from=GBP&to=EUR");
        // URLConnection connection = url.openConnection();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        bufferedReader.lines().forEach(
                builder::append
        );
        System.out.println(builder.toString());

        Gson gson = new Gson();
        Rate rate = gson.fromJson(builder.toString(), Rate.class);
        System.out.println(rate.base + " " + rate.amount);

        System.out.println(gson.toJson(rate));
    }
}
