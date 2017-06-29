package com.bawei.wangxueshi.fengzhuangmvpandretrofit.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
//Activity 类的根
public class IActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i);

    }



}
