package cn.marioquer.labpecker.Util;

import retrofit.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by marioquer on 2017/6/23.
 */

public class RetrofitUtil {

    private static Retrofit retrofit = null;

    public static <T> T getRetroService(final Class<T> service){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://115.29.184.56:8090/api/")
                    .build();
            return retrofit.create(service);
        }else{
            return retrofit.create(service);
        }
    }
}
