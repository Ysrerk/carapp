package RestApi;

import Models.Member;
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
}
