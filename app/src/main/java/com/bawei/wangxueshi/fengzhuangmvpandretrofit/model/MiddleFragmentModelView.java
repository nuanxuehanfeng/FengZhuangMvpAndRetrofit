package com.bawei.wangxueshi.fengzhuangmvpandretrofit.model;


public interface MiddleFragmentModelView {

    //获得数据
    void getData(String path,MiddleFragmentModelimpl.GetDataResultListener listener);
}
