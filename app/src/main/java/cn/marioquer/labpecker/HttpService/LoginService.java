package cn.marioquer.labpecker.HttpService;
import cn.marioquer.labpecker.Bean.User;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by marioquer on 2017/6/29.
 */

public interface LoginService {
    @POST("user/auth")
    Call<User> login(@Body RequestBody requestBody);
}
