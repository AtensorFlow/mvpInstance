package com.mvpinstance.mvp.main;

import com.mvpinstance.mvp.basic.BaseView;


public interface MainView extends BaseView {

    void getDataSuccess(MainModel model);

    void getDataFail(String msg);

}
