package com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.adapter.FirstFViewPagerAdapter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.BaseObserver;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.network.RetrofitFactory;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.shan.FirstBean;
import com.google.gson.Gson;
import com.xys.libzxing.zxing.activity.ZxingActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private TabLayout tablayout;
    private ViewPager pager;
   private Gson gson=new Gson();
    List<FirstBean.DataBean.TagBean> list=new ArrayList<>();
    private FirstFViewPagerAdapter firstFViewPagerAdapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            firstFViewPagerAdapter.notifyDataSetChanged();
        }
    };
    private ImageView scan;

    public FirstFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
          //发现控件
        initView(view);
        return  view ;
    }

    private void initView(View view) {
        tablayout = (TabLayout) view.findViewById(R.id.first_fragment_tablayout);
        pager = (ViewPager) view.findViewById(R.id.first_fragment_viewpager);

        scan = (ImageView) view.findViewById(R.id.first_fragment_iv_scan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ZxingActivity.class));
            }
        });

        firstFViewPagerAdapter = new FirstFViewPagerAdapter(getChildFragmentManager(),list);
        pager.setAdapter(firstFViewPagerAdapter);
//绑定aa
        tablayout.setupWithViewPager(pager);
//字体颜色
        tablayout.setTabTextColors(getResources().getColor(R.color.tab_normal_textcolor), getResources().getColor(R.color.tab_selected_textcolor));
//指示器颜色
        tablayout.setSelectedTabIndicatorColor(Color.RED);
//模式
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    //请求数据
        String path="http://lib.suning.com/app/redbaby/80000_8.2.0-155.json";

        RetrofitFactory.get(path, new BaseObserver() {
            @Override
            public void onSuccess(String result) {
                FirstBean firstBean = gson.fromJson(result, FirstBean.class);
                List<FirstBean.DataBean> data = firstBean.getData();
                List<FirstBean.DataBean.TagBean> tag = data.get(0).getTag();
                FirstBean.DataBean.TagBean tagBean = new FirstBean.DataBean.TagBean();
                tagBean.setElementName("上新");
                tagBean.setElementDesc("http://lib.suning.com/app/redbaby/80000_8.2.0-155.json");
                 tag.add(0,tagBean);
                list.addAll(tag);
              //  handler.sendEmptyMessage(1);

               firstFViewPagerAdapter.notifyDataSetChanged();

            }
            @Override
            public void onFailed() {
            }
        });




    }

}
