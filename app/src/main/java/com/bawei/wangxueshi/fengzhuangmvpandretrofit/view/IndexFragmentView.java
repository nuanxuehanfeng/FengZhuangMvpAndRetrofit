package com.bawei.wangxueshi.fengzhuangmvpandretrofit.view;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstShangXinBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */

public interface IndexFragmentView {

  void  getDataOnSuccess(List<FirstShangXinBean.DataBean> data);
  void  getDataOnFailed(String failed);

}
