package com.bawei.wangxueshi.fengzhuangmvpandretrofit.presenter;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.base.BasePresenter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstMiddleBean;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.model.MiddleFragmentModelimpl;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.view.MiddleFragmentView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class MiddleFragmentPresenter extends BasePresenter<MiddleFragmentView> {

    private MiddleFragmentModelimpl model;

    public MiddleFragmentPresenter() {
        model=new MiddleFragmentModelimpl();
    }

    public void getData(String path){

       model.getData(path, new MiddleFragmentModelimpl.GetDataResultListener() {
           @Override
           public void onSuccess(List<FirstMiddleBean.DataBean> data) {
                  view.getDataOnSuccess(data);
           }
           @Override
           public void onFailed(String failed) {
                     view.getDataOnFailed(failed);
           }
       });

    }





}
