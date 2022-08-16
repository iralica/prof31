package Lesson5.json;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GeoCoderService {
    void getGeoCode(String ip);
    @GET("/{ip}")
    Call<GeoCode> getGeoCode
}
