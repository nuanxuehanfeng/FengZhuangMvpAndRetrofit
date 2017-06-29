package com.bawei.wangxueshi.fengzhuangmvpandretrofit.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments.first.IndexFragment;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments.first.MiddleFragment;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.shan.FirstBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */

public class FirstFViewPagerAdapter extends FragmentPagerAdapter {

    List<FirstBean.DataBean.TagBean> tag;

    public FirstFViewPagerAdapter(FragmentManager fm, List<FirstBean.DataBean.TagBean> tag) {
        super(fm);
        this.tag = tag;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;

        if(position==0){
            fragment = new IndexFragment();
             Bundle bundle=new Bundle();
             bundle.putString("LinkUrl",tag.get(position).getElementDesc());
            fragment.setArguments(bundle);}
        else {
            fragment=new MiddleFragment();
            Bundle bundle=new Bundle();
            bundle.putString("LinkUrl","http://"+tag.get(position).getElementDesc());
            fragment.setArguments(bundle);
        }
        System.out.println(position+" = " + tag.get(position).getElementDesc());
        return fragment;
    }
    @Override
    public int getCount() {
        return tag.size()==0?0:tag.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tag.get(position).getElementName();
    }

}
