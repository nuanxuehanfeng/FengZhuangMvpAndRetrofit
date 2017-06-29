package com.bawei.wangxueshi.fengzhuangmvpandretrofit.presenter;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.base.BasePresenter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstShangXinBean;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.model.IndexFragmentModelimpl;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.view.IndexFragmentView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */

public class IndexFragmentPresenter extends BasePresenter<IndexFragmentView> {

    private IndexFragmentModelimpl model;

    public IndexFragmentPresenter() {
        model=new IndexFragmentModelimpl();
    }

    public void getData(String path){

        model.getData(path, new IndexFragmentModelimpl.GetDataResultListener() {
            @Override
            public void onSuccess(List<FirstShangXinBean.DataBean> data) {
                  view.getDataOnSuccess(data);
            }

            @Override
            public void onFailed(String failed) {
                view.getDataOnFailed(failed);
            }
        });

    }



}
