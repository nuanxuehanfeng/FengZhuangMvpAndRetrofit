package com.bawei.wangxueshi.fengzhuangmvpandretrofit.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstShangXinBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/21.
 */

public class IndexIrecycleAdapter extends RecyclerView.Adapter {

    Context context;
    List<FirstShangXinBean.DataBean> list;


    public IndexIrecycleAdapter(Context context) {
        this.context = context;
       // this.list = list;
    }

    public void setData(List<FirstShangXinBean.DataBean> data) {
        if (list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.firstfragment_recycler_adpter, null);
        Holder1 holder1 = new Holder1(view);
        return holder1;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //如集合为空
        if (list == null || list.size() == 0) {
            System.out.println("\"集合数据为空\" = " + "集合数据为空");
            return;
        }
        Holder1 holder1 = (Holder1) holder;
        //添加title
        String imag = "http://image3.suning.cn" + list.get(1).getTag().get(0).getPicUrl();

        Glide.with(context).load(imag).into(holder1.adapterFirstfragmentRecyclerIvTitle);

        //每日
        List<FirstShangXinBean.DataBean.TagBean> tag = list.get(2).getTag();
        for (int i = 0; i < tag.size(); i++) {
            LinearLayout layout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);

            if(i==0){
                layoutParams.setMargins(9,0,0,0);
            }

            layout.setLayoutParams(layoutParams);
         //   layout.setPadding(9,9,3,3);
            //动态分布权重
            // layout.setLayoutParams(new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f));
            layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
            //图片
            String imag1 = "http://image3.suning.cn" + tag.get(i).getPicUrl();
            ImageView imageView = new ImageView(context);
            Glide.with(context).load(imag1).into(imageView);

            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(50, 50);
            layoutParams1.leftMargin=9;
            layoutParams1.weight=1;
            imageView.setLayoutParams(layoutParams1);

            //文字
            TextView tv = new TextView(context);
            tv.setText(tag.get(i).getElementName());
            tv.setTextColor(context.getResources().getColor(R.color.text_hui));
            layout.addView(imageView);
            layout.addView(tv);
            holder1.adapterFirstfragmentRecyclerLilayoutTitle.addView(layout);
        }
        //十点秒杀
        List<FirstShangXinBean.DataBean.TagBean> tag1 = list.get(3).getTag();

        for (int i = 0; i < tag1.size(); i++) {
            String imag1 = "http://image3.suning.cn" + tag1.get(i).getPicUrl();
            //十点图片
            if (i == 0) {
                Glide.with(context).load(imag1).into(holder1.adapterFirstfragmentRecyclerIvShidian);
            }
            //内容图片
            else {
                LinearLayout layout = new LinearLayout(context);
                layout.setPadding(3, 3, 3, 3);
                layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
                //图片
                ImageView imageView = new ImageView(context);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100,80);
                imageView.setLayoutParams(params);
                Glide.with(context).load(imag1).into(imageView);
                //价格
                TextView tv = new TextView(context);
                tv.setGravity(Gravity.CENTER);
                tv.setText("$50.00");
                tv.setTextColor(Color.RED);
                layout.addView(imageView);
                layout.addView(tv);
                holder1.adapterFirstfragmentRecyclerLinearlayoutShidian.addView(layout);
            }
        }


        //活动
        String imag1 = "http://image3.suning.cn"+ list.get(5).getTag().get(0).getPicUrl();

        Glide.with(context).load(imag1).into(holder1.adapterFirstfragmentRecyclerIvAction);
        List<FirstShangXinBean.DataBean.TagBean> tag2 = list.get(6).getTag();
        for(int i=0;i<tag2.size();i++){
            ImageView imageView = new ImageView(context);
            imageView.setPadding(0,0,2,0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f);
            imageView.setLayoutParams(params);
            String imag2 = "http://image3.suning.cn"+tag2.get(i).getPicUrl();
            Glide.with(context).load(imag2).into(imageView);
            holder1.adapterFirstfragmentRecyclerLilayoutAction.addView(imageView);
        }
        //知识
        String imag2 = "http://image3.suning.cn"+ list.get(8).getTag().get(0).getPicUrl();

        Glide.with(context).load(imag2).into(holder1.adapterFirstfragmentRecyclerIvKnowledge);
        //第一行
        List<FirstShangXinBean.DataBean.TagBean> tag3 = list.get(9).getTag();
        for(int i=0;i<tag3.size();i++){
            ImageView imageView = new ImageView(context);
            imageView.setPadding(0,0,2,0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f);
            imageView.setLayoutParams(params);
            String imag3 = "http://image3.suning.cn"+tag3.get(i).getPicUrl();
            Glide.with(context).load(imag3).into(imageView);
            holder1.adapterFirstfragmentRecyclerLilayoutKnowledge1.addView(imageView);
        }
        //第二行
        List<FirstShangXinBean.DataBean.TagBean> tag4 = list.get(10).getTag();
        for(int i=0;i<tag4.size();i++){
            ImageView imageView = new ImageView(context);
            imageView.setPadding(0,0,2,0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f);
            imageView.setLayoutParams(params);
            String imag3 = "http://image3.suning.cn"+tag4.get(i).getPicUrl();
            Glide.with(context).load(imag3).into(imageView);
            holder1.adapterFirstfragmentRecyclerLilayoutKnowledge2.addView(imageView);
        }
        //第三行
        List<FirstShangXinBean.DataBean.TagBean> tag5 = list.get(11).getTag();
        for(int i=0;i<tag5.size();i++){
            ImageView imageView = new ImageView(context);
            imageView.setPadding(0,0,2,0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,1.0f);
            imageView.setLayoutParams(params);
            String imag3 = "http://image3.suning.cn"+tag5.get(i).getPicUrl();
            Glide.with(context).load(imag3).into(imageView);
            holder1.adapterFirstfragmentRecyclerLilayoutKnowledge3.addView(imageView);
        }
        //品牌
        String imag3 = "http://image3.suning.cn"+ list.get(13).getTag().get(0).getPicUrl();

        Glide.with(context).load(imag3).into(holder1.adapterFirstfragmentRecyclerIvBrand);
        //第一个品牌
        String imag4 = "http://image3.suning.cn"+ list.get(14).getTag().get(0).getPicUrl();

        Glide.with(context).load(imag4).into(holder1.adapterFirstfragmentRecyclerIvBrand1);

       //第一个品牌的内容
        List<FirstShangXinBean.DataBean.TagBean> tag6 = list.get(15).getTag();
        for (int i = tag6.size()-1 ; i >=0; i--) {
            String imag6 = "http://image3.suning.cn" + tag6.get(i).getPicUrl();
                LinearLayout layout = new LinearLayout(context);
                layout.setPadding(3, 3, 3, 3);
                layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
                //图片
                ImageView imageView = new ImageView(context);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100,80);
                imageView.setLayoutParams(params);
                Glide.with(context).load(imag6).into(imageView);
                //价格
                TextView tv = new TextView(context);
                tv.setGravity(Gravity.CENTER);
                tv.setText("$50.00");
                tv.setTextColor(Color.RED);
                layout.addView(imageView);
                layout.addView(tv);
                holder1.adapterFirstfragmentRecyclerLilayoutBrand1.addView(layout);
        }
        //第二个品牌
        String imag5 = "http://image3.suning.cn"+ list.get(16).getTag().get(0).getPicUrl();

        Glide.with(context).load(imag5).into(holder1.adapterFirstfragmentRecyclerIvBrand2);

        //第二个品牌的内容
        List<FirstShangXinBean.DataBean.TagBean> tag7 = list.get(17).getTag();
        for (int i = tag7.size()-1 ; i >=0; i--) {
            String imag6 = "http://image3.suning.cn" + tag7.get(i).getPicUrl();
            LinearLayout layout = new LinearLayout(context);
            layout.setPadding(3, 3, 3, 3);
            layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
            //图片
            ImageView imageView = new ImageView(context);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100,80);
            imageView.setLayoutParams(params);
            Glide.with(context).load(imag6).into(imageView);
            //价格
            TextView tv = new TextView(context);
            tv.setGravity(Gravity.CENTER);
            tv.setText("$50.00");
            tv.setTextColor(Color.RED);
            layout.addView(imageView);
            layout.addView(tv);
            holder1.adapterFirstfragmentRecyclerLilayoutBrand2.addView(layout);
        }




    }


    @Override
    public int getItemCount() {
        return 1;
    }

    class Holder1 extends RecyclerView.ViewHolder {

        @BindView(R.id.adapter_firstfragment_recycler_iv_title)
        ImageView adapterFirstfragmentRecyclerIvTitle;
        @BindView(R.id.adapter_firstfragment_recycler_lilayout_title)
        LinearLayout adapterFirstfragmentRecyclerLilayoutTitle;
        @BindView(R.id.adapter_firstfragment_recycler_iv_shidian)
        ImageView adapterFirstfragmentRecyclerIvShidian;
        @BindView(R.id.adapter_firstfragment_recycler_linearlayout_shidian)
        LinearLayout adapterFirstfragmentRecyclerLinearlayoutShidian;
        @BindView(R.id.adapter_firstfragment_recycler_horizentals_shidian)
        HorizontalScrollView adapterFirstfragmentRecyclerHorizentalsShidian;
        @BindView(R.id.adapter_firstfragment_recycler_iv_action)
        ImageView adapterFirstfragmentRecyclerIvAction;
        @BindView(R.id.adapter_firstfragment_recycler_lilayout_action)
        LinearLayout adapterFirstfragmentRecyclerLilayoutAction;
        @BindView(R.id.adapter_firstfragment_recycler_iv_knowledge)
        ImageView adapterFirstfragmentRecyclerIvKnowledge;
        @BindView(R.id.adapter_firstfragment_recycler_lilayout_knowledge1)
        LinearLayout adapterFirstfragmentRecyclerLilayoutKnowledge1;
        @BindView(R.id.adapter_firstfragment_recycler_lilayout_knowledge2)
        LinearLayout adapterFirstfragmentRecyclerLilayoutKnowledge2;
        @BindView(R.id.adapter_firstfragment_recycler_lilayout_knowledge3)
        LinearLayout adapterFirstfragmentRecyclerLilayoutKnowledge3;
        @BindView(R.id.adapter_firstfragment_recycler_iv_brand)
        ImageView adapterFirstfragmentRecyclerIvBrand;
        @BindView(R.id.adapter_firstfragment_recycler_iv_brand1)
        ImageView adapterFirstfragmentRecyclerIvBrand1;
        @BindView(R.id.adapter_firstfragment_recycler_lilayout_brand1)
        LinearLayout adapterFirstfragmentRecyclerLilayoutBrand1;
        @BindView(R.id.adapter_firstfragment_recycler_horozontal_brand1)
        HorizontalScrollView adapterFirstfragmentRecyclerHorozontalBrand1;
        @BindView(R.id.adapter_firstfragment_recycler_iv_brand2)
        ImageView adapterFirstfragmentRecyclerIvBrand2;
        @BindView(R.id.adapter_firstfragment_recycler_lilayout_brand2)
        LinearLayout adapterFirstfragmentRecyclerLilayoutBrand2;
        @BindView(R.id.adapter_firstfragment_recycler_horozontal_brand2)
        HorizontalScrollView adapterFirstfragmentRecyclerHorozontalBrand2;

        public Holder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            // title= (ImageView) itemView.findViewById(R.id.adapter_firstfragment_recycler_iv_title);


        }
    }


}
