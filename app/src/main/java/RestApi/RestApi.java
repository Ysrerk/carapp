package RestApi;

import Models.Advresult;
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

    @FormUrlEncoded
    @POST("/addadver.php")
    Call<Advresult> addadv(@Field("memberid") String memberid, @Field("title") String title, @Field("description") String description, @Field("province") String province, @Field("city") String city , @Field("year") String year, @Field("make") String make, @Field("model") String model, @Field("colour") String colour , @Field("fueltype") String fueltype, @Field("kilometer") String kilometer, @Field("price") String price);
}
