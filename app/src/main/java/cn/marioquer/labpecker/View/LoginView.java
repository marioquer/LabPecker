package cn.marioquer.labpecker.View;

/**
 * Created by marioquer on 2017/6/30.
 */

public interface LoginView {
    //按钮点击
    public void doLogin();
    //交互相关
    public void showProgress(final boolean show);
    public void loginError(boolean isError);
    //跳转
    public void jumpToHome(String type);
}
