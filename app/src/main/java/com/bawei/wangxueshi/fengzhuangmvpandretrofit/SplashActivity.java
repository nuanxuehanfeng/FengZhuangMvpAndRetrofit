package com.bawei.wangxueshi.fengzhuangmvpandretrofit;

import android.content.Intent;
import android.os.Bundle;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.activitys.TabActivity;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.base.BaseMvpActivity;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.presenter.SplashPresenter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.view.SplashView;

public class SplashActivity extends BaseMvpActivity<SplashView,SplashPresenter> {

    @Override
    public SplashPresenter initPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, TabActivity.class));
        finish();
    }
}
