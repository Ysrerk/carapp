package RestApi;

import java.util.List;

import Models.AddFavorite;
import Models.Addimage;
import Models.Ads;
import Models.Adsdetail;
import Models.Advresult;
import Models.Favorite;
import Models.Member;
import Models.Register;
import Models.RemoveFavorite;
import Models.SliderImage;
import Models.Verification;
import retrofit2.Call;

public class ManagerAll  extends  BaseManager{

    private static ManagerAll getinstance=new ManagerAll();
    public  static  synchronized ManagerAll getInstance(){
        return getinstance;

    }
    public Call<Member> getmember(String email, String password){
        Call<Member> member= getRestApiClient().control(email,password);
        return member;

    }
    public Call<Register> registerm(String email, String password,String username,String phone,String country){
        Call<Register> registration= getRestApiClient().register(email,password,username,phone,country);
        return registration;

    }
    public Call<Verification> verifymember(String verificationcode){
        Call<Verification> verifymember= getRestApiClient().verify(verificationcode);
        return verifymember;

    }

    public Call<Advresult> addadv(String memberid,String title,String description,String province,String city,String year,String make,String model,String colour,String fueltype,String kilometer,String price){
        Call<Advresult> advresult= getRestApiClient().addadv(memberid,title,description,province,city,year,make,model,colour,fueltype,kilometer,price);
        return advresult;

    }

    public Call<Addimage> addimage(String memberid,String advid,String image){
        Call<Addimage> verifymember= getRestApiClient().addimage(memberid,advid,image);
        return verifymember;

    }

    public Call<List<Ads>>getAds(){
        Call<List<Ads>> ads=getRestApiClient().listads();
        return ads;
    }

    public Call<Adsdetail> getadsdetail(String advid){
        Call<Adsdetail> adsdetail=getRestApiClient().adsdetail(advid);
        return adsdetail;

    }

    public Call<List<SliderImage>> getadimage(String advid){
        Call<List<SliderImage>> addimage=getRestApiClient().adimages(advid);
        return addimage;

    }

    public Call<AddFavorite> addfavorite(String memberid, String advid){
        Call<AddFavorite> addfavoritee= getRestApiClient().addfavorite(memberid,advid);
        return addfavoritee;

    }
    public Call<RemoveFavorite> removefavorite(String memberid, String advid){
        Call<RemoveFavorite> removefavoritee= getRestApiClient().removefavorite(memberid,advid);
        return removefavoritee;

    }

    public Call<List<Favorite>>getfavorites(String memberid){
        Call<List<Favorite>> favoritee=getRestApiClient().favorites(memberid);
        return favoritee;
    }
}
