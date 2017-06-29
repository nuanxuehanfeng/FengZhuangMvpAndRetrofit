package com.bawei.wangxueshi.fengzhuangmvpandretrofit.model;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstShangXinBean;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.BaseObserver;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.RetrofitFactory;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class IndexFragmentModelimpl implements  IndexFragmentModelView {
      private Gson gson=new Gson();
    @Override
    public void getData(String path, final GetDataResultListener listener) {
        RetrofitFactory.get(path).subscribe(new BaseObserver() {
            @Override
            public void onSuccess(String result) {

                FirstShangXinBean bean = gson.fromJson(result, FirstShangXinBean.class);
                List<FirstShangXinBean.DataBean> data = bean.getData();

                listener.onSuccess(data);
            }
            @Override
            public void onFailed() {
                String failed="获得数据失败";
                listener.onFailed(failed);
            }
        });
    }
  public  interface GetDataResultListener{
        void onSuccess(List<FirstShangXinBean.DataBean> data);
        void onFailed(String failed);
    }
}
