package com.bawei.wangxueshi.fengzhuangmvpandretrofit.wxapi;

import android.os.Bundle;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
import com.umeng.weixin.callback.WXCallbackActivity;

public class WXEntryActivity extends WXCallbackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxentry);
    }
}
