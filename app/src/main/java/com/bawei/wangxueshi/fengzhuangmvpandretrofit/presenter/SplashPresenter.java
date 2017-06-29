package com.bawei.wangxueshi.fengzhuangmvpandretrofit.presenter;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.base.BasePresenter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.model.SplashModelimpl;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.view.SplashView;

/**
 * Created by Administrator on 2017/6/19.
 */

public class SplashPresenter extends BasePresenter<SplashView> {

    private SplashModelimpl splashModelimpl;

    public SplashPresenter() {
        splashModelimpl=new SplashModelimpl();
    }


    public void getData(){

        splashModelimpl.getData();

    }

}
