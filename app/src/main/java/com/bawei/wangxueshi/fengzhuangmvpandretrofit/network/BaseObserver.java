package com.bawei.wangxueshi.fengzhuangmvpandretrofit.network;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/6/20.
 */

public abstract class BaseObserver implements Observer<String>{
    @Override
    public void onSubscribe(@NonNull Disposable d) {
    }

    @Override
    public void onNext(@NonNull String s) {
        onSuccess(s);
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    public abstract  void  onSuccess(String result);
    public abstract  void  onFailed();




}
