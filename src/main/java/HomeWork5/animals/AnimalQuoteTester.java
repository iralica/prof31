package HomeWork5.animals;
// facts/random?animal_type=dog&amount=2
// @Query ? и & добавляются автоматически

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class AnimalQuoteTester {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cat-fact.herokuapp.com")// что вызвать
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // ретрофит нужен чтобы создать класс имплементящий аннота

        AnimalsService service = retrofit.create(AnimalsService.class);

        Call<List<Fact>> call = service.getFacts("dog", 3);

        Response<List<Fact>> response = call.execute(); // результат запроса
        if (response.isSuccessful()) {
            List<Fact> facts = response.body();
            for (Fact f : facts) {
                System.out.println(f.getText());
            }

        }
    }
}
