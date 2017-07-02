package cn.marioquer.labpecker.Util;

import java.io.IOException;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marioquer on 2017/6/23.
 */

public class RetrofitUtil {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "http://115.29.184.56:8090/api/";
    private static OkHttpClient httpClient;

    public static <T> T getRetroService(final Class<T> service) {
        if (retrofit == null)
            return getRetroService(service, null, null);
        else
            return retrofit.create(service);
    }

    public static <T> T getRetroService(final Class<T> service, String username, String password) {
        if (username != null && password != null) {
            final String credentials = Credentials.basic(username, password);
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            Request authenticatedRequest = request.newBuilder()
                                    .header("Authorization", credentials).build();
                            return chain.proceed(authenticatedRequest);
                        }
                    })
                    .build();
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(service);
    }
}
