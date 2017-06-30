package cn.marioquer.labpecker.View;

/**
 * Created by marioquer on 2017/6/30.
 */

public interface LoginView {
    public void doLogin();
    public void showProgress(final boolean show);
    public void loginError(boolean isError);
    public void jumpToHome(String type);
}
