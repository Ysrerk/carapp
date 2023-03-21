package RestApi;

import java.util.List;

import Models.Addimage;
import Models.Ads;
import Models.Advresult;
import Models.Member;
import Models.Register;
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
}
