package com.bawei.wangxueshi.fengzhuangmvpandretrofit.view;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstMiddleBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
public interface MiddleFragmentView {
    void  getDataOnSuccess(List<FirstMiddleBean.DataBean> data);
    void  getDataOnFailed(String failed);
}
