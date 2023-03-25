package RestApi;

import java.util.List;

import Models.Addimage;
import Models.Ads;
import Models.Adsdetail;
import Models.Advresult;
import Models.Member;
import Models.Register;
import Models.SliderImage;
import Models.Verification;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @FormUrlEncoded
    @POST("/addimage.php")
    Call<Addimage> addimage(@Field("memberid") String memberid, @Field("advid") String advid, @Field("image") String base64String);

    @GET("/ads.php")
    Call<List<Ads>> listads();

    @GET("/adsdetail.php")
    Call<Adsdetail> adsdetail(@Query("advid") String advid);

    @GET("/adimages.php")
    Call<List<SliderImage>> adimages(@Query("advid") String advid);

}
