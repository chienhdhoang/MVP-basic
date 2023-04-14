package com.example.stepbystep.presenter;

public interface ILoginPresenter {
    void clear();
    void doLogin(String name, String passwd);
    void setProgressBarVisibility(int visiblity);
}
