package com.bawei.wangxueshi.fengzhuangmvpandretrofit.model;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.base.BasePresenter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstMiddleBean;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.BaseObserver;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.RetrofitFactory;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.view.MiddleFragmentView;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class MiddleFragmentModelimpl extends BasePresenter<MiddleFragmentView> implements  MiddleFragmentModelView {
    @Override
    public void getData(String path, final MiddleFragmentModelimpl.GetDataResultListener listener) {

        RetrofitFactory.get(path, new BaseObserver() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                FirstMiddleBean bean = gson.fromJson(result, FirstMiddleBean.class);
                listener.onSuccess(bean.getData());
            }
            @Override
            public void onFailed() {
                listener.onFailed("获取数据失败，中间的");
            }
        });
    }
    
    
    
  public  interface  GetDataResultListener{
      void onSuccess(List<FirstMiddleBean.DataBean> data);
      void onFailed(String failed);
      
  }
    
}
