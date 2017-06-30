package cn.marioquer.labpecker;


import org.junit.Test;

import cn.marioquer.labpecker.Bean.User;
import cn.marioquer.labpecker.HttpService.LoginService;
import cn.marioquer.labpecker.Util.RetrofitUtil;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void loginTest() throws Exception{
//        Call<User> call = RetrofitUtil.getRetroService(LoginService.class).login("liuqin","123");
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                System.out.println(user.toString());
//                assertEquals("aaaa","aaa");
//
//            }
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                System.out.println("aaaa");
//                assertEquals("a","aa");
//            }
//        });
//
//    }

    public static void main(String[] args){


    }
}