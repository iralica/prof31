package HomeWork5.animals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

// [{"status":{"verified":true,"sentCount":1},"_id":"5c871dac85c8b40e7ed683e7","source":"user","type":"dog","deleted":false,
// "user":"5a9ac18c7478810ea6c06381","text":"It’s rumored that, at the end of the Beatles song,
// “A Day in the Life,” Paul McCartney recorded an ultrasonic whistle, audible only to dogs,
// just for his Shetland sheepdog.","createdAt":"2019-03-12T02:47:08.504Z",
// "updatedAt":"2020-09-02T20:20:04.107Z","__v":0,"used":true},{"status":{"verified":true,"sentCount":1},"_id":"5b12d7d5cf4b960d5eb02ec9",
// "updatedAt":"2020-08-23T20:20:01.611Z","createdAt":"2018-08-06T20:20:02.470Z",
// "user":"5a9ac18c7478810ea6c06381","text":"Dogs perform many useful tasks for humans including hunting,
// farm work and security as well as assisting those with disabilities such as the blind.",
// "deleted":false,"type":"dog","source":"user","__v":0,"used":false}]
public interface AnimalsService {
    @GET("facts/random")
    Call<List<Fact>> getFacts(
        @Query("animal_type") String animal,
        @Query("amount") int number
    );

    @GET("facts/random")
    void getFact();
}
