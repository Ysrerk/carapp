package RestApi;

import Models.Member;
import Models.Register;
import Models.Verification;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/login.php")
    Call<Member> control(@Field("email") String email, @Field("password") String password);
    @FormUrlEncoded
    @POST("/register.php")
    Call<Register> register(@Field("email") String email, @Field("password") String password, @Field("username") String username, @Field("phone") String phone, @Field("country") String country);

    @FormUrlEncoded
    @POST("/verification.php")
    Call<Verification> verify(@Field("verificationcode") String verificationcode);
}
