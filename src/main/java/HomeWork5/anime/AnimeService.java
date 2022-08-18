package HomeWork5.anime;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnimeService {
    @GET("api/v1/{anime}") // {anime} это шаблон который заменяется на значение параметра name
    Call<Anime> getAnime(@Path("anime") String name);
}
