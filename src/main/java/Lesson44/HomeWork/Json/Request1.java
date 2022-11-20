package Lesson44.HomeWork.Json;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class Request1 {
    public static Rate1 getRate1(double amount, String from, String to) {
        Gson gson = new Gson();
        Rate1 result = null;
        try {
            URL url = new URL("https://api.frankfurter.app/latest?amount=" + amount + "&from=" + from + "&to=" + to);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            Reader reader = new InputStreamReader(connection.getInputStream());
            result = gson.fromJson(reader, Rate1.class);
        } catch (Exception e) {
            System.err.println("Exception in getRate " + e.getMessage());
        }
        return result;
    }
}
