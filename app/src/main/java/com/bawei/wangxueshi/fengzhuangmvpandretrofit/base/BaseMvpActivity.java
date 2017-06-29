package com.bawei.wangxueshi.fengzhuangmvpandretrofit.base;

import android.os.Bundle;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
//参数，当前的view ，当前的presenter
public abstract class BaseMvpActivity<V,T extends BasePresenter<V>> extends IActivity {
    //继承这个类，都需要实现抽象方法，完成presenter 的创建
   //属性
    public T presenter;
    //定义 一个抽象方法 ，返回的是presenter
    public abstract  T initPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_mvp);

        presenter=initPresenter();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
