package cn.marioquer.labpecker.Presenter.Impl;

import android.util.Log;

import cn.marioquer.labpecker.Bean.User;
import cn.marioquer.labpecker.HttpService.LoginService;
import cn.marioquer.labpecker.Presenter.LoginPresenter;
import cn.marioquer.labpecker.Util.RetrofitUtil;
import cn.marioquer.labpecker.View.LoginView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by marioquer on 2017/6/30.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView = null;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void doLogin(String username, String password) {
        String json = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        loginView.showProgress(true);
        loginView.loginError(false);

        Call<User> call = RetrofitUtil.getRetroService(LoginService.class).login(requestBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                loginView.showProgress(false);
                loginView.jumpToHome(response.body().getType());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loginView.showProgress(false);
                loginView.loginError(true);
            }
        });
    }
}
