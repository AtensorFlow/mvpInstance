package com.mvpinstance;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mvpinstance.mvp.basic.MvpActivity;
import com.mvpinstance.mvp.main.MainModel;
import com.mvpinstance.mvp.main.MainPresenter;
import com.mvpinstance.mvp.main.MainView;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getDataSuccess(MainModel model) {
        //接口成功回调
        dataSuccess(model);
    }

    @Override
    public void getDataFail(String msg) {
        toastShow("error");

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                mvpPresenter.loadDataByRetrofitRxjava("101310222");
                break;
        }
    }


    private void dataSuccess(MainModel model) {
        MainModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
        String showData =  weatherinfo.getCity()
                + weatherinfo.getWD()
                + weatherinfo.getWS()
                + weatherinfo.getTime();
        text.setText(showData);
    }
}
