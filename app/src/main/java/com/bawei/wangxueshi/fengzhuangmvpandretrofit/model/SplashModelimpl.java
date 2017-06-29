package com.bawei.wangxueshi.fengzhuangmvpandretrofit.model;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.BaseObserver;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.RetrofitFactory;

/**
 * Created by Administrator on 2017/6/19.
 */

public class SplashModelimpl {
    public void getData(){
        RetrofitFactory.get("http://qhb.2dyt.com/Bwei/login?username=11111111111&password=1&postkey=1503d").subscribe(new BaseObserver() {
            @Override
            public void onSuccess(String result) {
                System.out.println("result = " + result);
            }
            @Override
            public void onFailed() {
            }
        });
    }




}
