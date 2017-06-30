package cn.marioquer.labpecker.Util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import cn.marioquer.labpecker.Bean.Group;
import cn.marioquer.labpecker.Bean.User;
import cn.marioquer.labpecker.HttpService.LoginService;
import cn.marioquer.labpecker.HttpService.TeacherService;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marioquer on 2017/5/21.
 */

public class NetworkUtil {

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = connection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            connection.disconnect();
        }
    }




    public static void main(String[] args){
//        String username = "nanguangtailang";
//        String password = "123";
//


        Call<List<Group>> call= RetrofitUtil.getRetroService(TeacherService.class,"liuqin","123").getGroups();
        call.enqueue(new Callback<List<Group>>() {
            @Override
            public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                System.out.println(response.body().get(0).getName());
            }

            @Override
            public void onFailure(Call<List<Group>> call, Throwable t) {

            }
        });



    }
}
