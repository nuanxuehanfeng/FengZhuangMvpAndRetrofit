package com.bawei.wangxueshi.fengzhuangmvpandretrofit.base;

/**
 * Created by Administrator on 2017/6/19.
 */

public abstract class BasePresenter<T> {

    //这个类 拥有的view
    public T view;

     public void attach(T view){
         this.view=view;
     }

    public void detach(){
        this.view=null;
    }

}
