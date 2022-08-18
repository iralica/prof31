package Lesson5.json;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitTester {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder() // билдер для настройки ретрофита
                .baseUrl("https://api.country.is/") // сайт
                .addConverterFactory(GsonConverterFactory.create()) // создавать ли объект по json
                .build(); // создание объекта класса Retrofit

        GeoCoderService service = retrofit.create(GeoCoderService.class);
        // просим ретрофит создать нам реализацию интерфейса
        // которая сможет выполнять http запросы

        Call<GeoCode> call = service.getGeoCode("178.248.238.19"); // запрос
        // response - результат запроса
        Response<GeoCode> response = call.execute(); // 1 вариант - синхронный запрос
        // call.enqueue(); // 2 вариант - асинхронный запрос - происходит в другом потоке выполнения
        if(response.isSuccessful()) // если результат запроса удачный
        {
            GeoCode geoCode = response.body(); // объект
            System.out.println("Country: " + geoCode.getCountry() + ", ip: " + geoCode.getIp());
        }
        System.exit(0);
    }
}
