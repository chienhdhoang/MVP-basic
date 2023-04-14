package com.example.stepbystep.presenter;

import android.util.Log;

import com.example.stepbystep.model.IUser;
import com.example.stepbystep.model.UserModel;
import com.example.stepbystep.view.ILoginView;

import java.util.logging.Handler;
public class LoginPresenterCompl implements ILoginPresenter {
    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Log.d("doLogin", "11");
        boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,passwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        iLoginView.onLoginResult(result, code);
    }

    @Override
    public void setProgressBarVisibility(int visibility){
        iLoginView.onSetProgressBarVisibility(visibility);
    }

    private void initUser(){
        user = new UserModel("mvp","mvp");
    }
}