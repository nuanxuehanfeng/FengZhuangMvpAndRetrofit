package com.bawei.wangxueshi.fengzhuangmvpandretrofit.model;

/**
 * Created by Administrator on 2017/6/21.
 */

public interface IndexFragmentModelView {
    //获得数据
       void getData(String path,IndexFragmentModelimpl.GetDataResultListener listener);

 }
