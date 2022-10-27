package Lesson24;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTester {
    public static void main(String[] args) {
        String webService = "https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD";

        try {
            System.out.println(
                    httpString(webService)
            );
        }
        catch (MalformedURLException e)
        {
            System.err.println("malformed: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println("io: " + e.getMessage());
        }

    }
    public static String httpString(String webService) throws IOException {
        URL url = new URL(webService);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        StringBuilder builder = new StringBuilder();
        try (
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        )
        {
            bufferedReader.lines()
                    .forEach(
                            builder::append
                    );
        }
        return builder.toString();
    }


}
