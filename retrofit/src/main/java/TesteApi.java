import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TesteApi {


    @Headers("student: 1111007843")
    @GET("api/tasks")
    Call<List<Time>> getTarefa();

    @Headers("student: 1111007843")
    @GET("api/tasks/{id}")
    Call<Time> getTarefa(@Path("id") int id);

    @Headers("student: 1111007843")
    @POST("api/tasks")
    Call<Time> setTarefa(@Body Time description);

    @Headers("student: 1111007843")
    @PUT("api/tasks/{id}")
    Call<Void> SetTarefa(@Path("id") int id, @Body Time description);

    @Headers("student: 1111007843")
    @DELETE("api/tasks/{id}")
    Call<Void> delTarefa(@Path("id") int id);

}