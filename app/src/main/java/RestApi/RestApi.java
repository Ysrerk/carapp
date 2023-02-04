package RestApi;

import Models.Member;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/login.php")
    Call<Member> control(@Field("email") String email, @Field("password") String password);
}
