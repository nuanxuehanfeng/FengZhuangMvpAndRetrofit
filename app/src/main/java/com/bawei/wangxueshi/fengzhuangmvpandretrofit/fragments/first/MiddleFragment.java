package com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments.first;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.base.BaseMvpFragment;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstMiddleBean;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.presenter.MiddleFragmentPresenter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.view.MiddleFragmentView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MiddleFragment extends BaseMvpFragment<MiddleFragmentView, MiddleFragmentPresenter> implements MiddleFragmentView {
    private static final String ARG_PARAM1 = "param1";

    Unbinder unbinder;
    @BindView(R.id.middlefragment_iv_title)
    ImageView middlefragmentIvTitle;
    @BindView(R.id.middlefragment_iv_shidian)
    ImageView middlefragmentIvShidian;
    @BindView(R.id.middlefragment_linearlayout_shidian)
    LinearLayout middlefragmentLinearlayoutShidian;
    @BindView(R.id.middlefragment_iv_action)
    ImageView middlefragmentIvAction;
    @BindView(R.id.middlefragment_linearlayout_action)
    LinearLayout middlefragmentLinearlayoutAction;
    @BindView(R.id.middlefragment_iv_brand)
    ImageView middlefragmentIvBrand;
    @BindView(R.id.middlefragment_iv_brand1)
    ImageView middlefragmentIvBrand1;
    @BindView(R.id.middlefragment_lilayout_brand1)
    LinearLayout middlefragmentLilayoutBrand1;
    @BindView(R.id.middlefragment_iv_brand2)
    ImageView middlefragmentIvBrand2;
    @BindView(R.id.middlefragment_lilayout_brand2)
    LinearLayout middlefragmentLilayoutBrand2;
    @BindView(R.id.middlefragment_iv_brand3)
    ImageView middlefragmentIvBrand3;
    @BindView(R.id.middlefragment_lilayout_brand3)
    LinearLayout middlefragmentLilayoutBrand3;
    @BindView(R.id.middlefragment_iv_brand4)
    ImageView middlefragmentIvBrand4;
    @BindView(R.id.middlefragment_lilayout_brand4)
    LinearLayout middlefragmentLilayoutBrand4;
    private String mParam1;
    private Unbinder bind;
   String imag= "http://image3.suning.cn";
    @Override
    public MiddleFragmentPresenter initPresenter() {
        return new MiddleFragmentPresenter();
    }

    public MiddleFragment() {
    }

    public static MiddleFragment newInstance(String param1, String param2) {
        MiddleFragment fragment = new MiddleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_middle, container, false);
        unbinder = ButterKnife.bind(this, view);

        Bundle arguments = getArguments();
        String path = arguments.getString("LinkUrl");

        presenter.getData(path);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    //获取成功
    @Override
    public void getDataOnSuccess(List<FirstMiddleBean.DataBean> data) {
        //标题图片
        String picUrl = imag+ data.get(0).get_$88001().getTag().get(0).getPicUrl();

        Glide.with(this).load(picUrl).into(middlefragmentIvTitle);

//十点秒杀
        List<FirstMiddleBean.DataBean._$88003Bean.TagBeanX> tag = data.get(1).get_$88003().getTag();
        for (int i = 0; i < tag.size(); i++) {
            String imag1 = imag + tag.get(i).getPicUrl();

            //十点图片
            if (i == 0) {
                Glide.with(this).load(imag1).into(middlefragmentIvShidian);
            }
            //内容图片
            else {
                LinearLayout layout = new LinearLayout(getContext());
                layout.setPadding(3, 3, 3, 3);
                layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
                //图片
                ImageView imageView = new ImageView(getContext());
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100,80);
                imageView.setLayoutParams(params);
                Glide.with(this).load(imag1).into(imageView);
                //价格
                TextView tv = new TextView(getContext());
                tv.setGravity(Gravity.CENTER);
                tv.setText("$50.00");
                tv.setTextColor(Color.RED);
                layout.addView(imageView);
                layout.addView(tv);
                middlefragmentLinearlayoutShidian.addView(layout);
            }
        }
        //活动专区

        List<FirstMiddleBean.DataBean._$88005Bean.TagBeanXXX> tag1 = data.get(3).get_$88005().getTag();
        if(tag1==null){
            System.out.println("\"车品\" = " + "这是车品");
        }
        else{
            System.out.println("\"其他\" = " + "这是其他");
            //活动标题
         String imag1=imag+tag1.get(0).getPicUrl();
            Glide.with(this).load(imag1).into(middlefragmentIvAction);
            //活动一
            FirstMiddleBean.DataBean._$88015Bean.TagBeanXXXX tagBeanXXXX = data.get(4).get_$88015().getTag().get(0);
            //图片

            String imag2=imag+tagBeanXXXX.getPicUrl();
            ImageView imageView = new ImageView(getContext());
            Glide.with(this).load(imag2).into(imageView);
            //名字
            TextView name=new TextView(getContext());
            name.setText(tagBeanXXXX.getElementName());
            name.setTextSize(20);
            name.setTextColor(getContext().getResources().getColor(R.color.text_hei));
            //描述
            TextView desc=new TextView(getContext());
            desc.setTextSize(15);
            desc.setTextColor(getContext().getResources().getColor(R.color.text_hui));
            desc.setText(tagBeanXXXX.getElementDesc());
            LinearLayout layout = new LinearLayout(getContext());
            layout.setOrientation(LinearLayout.HORIZONTAL);
            TextView price = new TextView(getContext());
            price.setTextColor(Color.RED);
            price.setTextSize(20);
            price.setText("$"+tagBeanXXXX.getItemPrice());
            price.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
            price.setGravity(Gravity.LEFT);

            Button buy = new Button(getContext());
            buy.setBackgroundColor(Color.RED);
            buy.setTextColor(Color.WHITE);
            buy.setText("开团");
            buy.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,0));
            //buy.setGravity(Gravity.RIGHT);
              layout.addView(price);
              layout.addView(buy);

            middlefragmentLinearlayoutAction.addView(imageView);
            middlefragmentLinearlayoutAction.addView(name);
            middlefragmentLinearlayoutAction.addView(desc);
            middlefragmentLinearlayoutAction.addView(layout);

            LinearLayout layout2 = new LinearLayout(getContext());
            layout2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,5));
            layout2.setBackgroundColor(getContext().getResources().getColor(R.color.text_hui));
            middlefragmentLinearlayoutAction.addView(layout2);
            //活动二
            FirstMiddleBean.DataBean._$88015Bean.TagBeanXXXX tagBeanXXXX2 = data.get(6).get_$88015().getTag().get(0);
            //图片

            String imag3=imag+tagBeanXXXX2.getPicUrl();
            ImageView imageView1 = new ImageView(getContext());
            Glide.with(this).load(imag3).into(imageView1);
            //名字
            TextView name1=new TextView(getContext());
            name1.setText(tagBeanXXXX2.getElementName());
            name1.setTextSize(20);
            name1.setTextColor(getContext().getResources().getColor(R.color.text_hei));
            //描述
            TextView desc1=new TextView(getContext());
            desc1.setTextSize(15);
            desc1.setTextColor(getContext().getResources().getColor(R.color.text_hui));
            desc1.setText(tagBeanXXXX2.getElementDesc());
            LinearLayout layout1 = new LinearLayout(getContext());
            layout1.setOrientation(LinearLayout.HORIZONTAL);
            TextView price1 = new TextView(getContext());
            price1.setTextColor(Color.RED);
            price1.setTextSize(20);
            price1.setText("$"+tagBeanXXXX2.getItemPrice());
            price1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
            price1.setGravity(Gravity.LEFT);

            Button buy1 = new Button(getContext());
            buy1.setBackgroundColor(Color.RED);
            buy1.setTextColor(Color.WHITE);
            buy1.setText("开团");
            buy1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,0));
            //buy.setGravity(Gravity.RIGHT);
            layout1.addView(price1);
            layout1.addView(buy1);

            middlefragmentLinearlayoutAction.addView(imageView1);
            middlefragmentLinearlayoutAction.addView(name1);
            middlefragmentLinearlayoutAction.addView(desc1);
            middlefragmentLinearlayoutAction.addView(layout1);




        }


        //品牌特卖
        //品牌
        String imag3 = imag+data.get(9).get_$88005().getTag().get(0).getPicUrl();

        Glide.with(getContext()).load(imag3).into(middlefragmentIvBrand);
        //第一个品牌
        String imag4 = imag3+ data.get(10).get_$88010().getTag().get(0).getPicUrl();

        Glide.with(getContext()).load(imag4).into(middlefragmentIvBrand1);

        //第一个品牌的内容
        List<FirstMiddleBean.DataBean._$88011Bean.TagBeanXXXXXXXX> tag6 = data.get(11).get_$88011().getTag();
        for (int i = tag6.size()-1 ; i >=0; i--) {
            String imag6 = imag + tag6.get(i).getPicUrl();
            LinearLayout layout = new LinearLayout(getContext());
            layout.setPadding(3, 3, 3, 3);
            layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
            //图片
            ImageView imageView = new ImageView(getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100,80);
            imageView.setLayoutParams(params);
            Glide.with(getContext()).load(imag6).into(imageView);
            //价格
            TextView tv = new TextView(getContext());
            tv.setGravity(Gravity.CENTER);
            tv.setText("$50.00");
            tv.setTextColor(Color.RED);
            layout.addView(imageView);
            layout.addView(tv);
           middlefragmentLilayoutBrand1.addView(layout);
        }
        //第二个品牌

        String imag5 = imag3+ data.get(12).get_$88010().getTag().get(0).getPicUrl();
        Glide.with(getContext()).load(imag5).into(middlefragmentIvBrand2);
        //第二个品牌内容
        List<FirstMiddleBean.DataBean._$88011Bean.TagBeanXXXXXXXX> tag7= data.get(13).get_$88011().getTag();
        for (int i = tag7.size()-1 ; i >=0; i--) {
            String imag6 = imag + tag7.get(i).getPicUrl();
            LinearLayout layout = new LinearLayout(getContext());
            layout.setPadding(3, 3, 3, 3);
            layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
            //图片
            ImageView imageView = new ImageView(getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100,80);
            imageView.setLayoutParams(params);
            Glide.with(getContext()).load(tag7).into(imageView);
            //价格
            TextView tv = new TextView(getContext());
            tv.setGravity(Gravity.CENTER);
            tv.setText("$50.00");
            tv.setTextColor(Color.RED);
            layout.addView(imageView);
            layout.addView(tv);
            middlefragmentLilayoutBrand2.addView(layout);
        }
        //第三个品牌

        String imag7 = imag3+ data.get(14).get_$88010().getTag().get(0).getPicUrl();
        Glide.with(getContext()).load(imag7).into(middlefragmentIvBrand3);
        //第二个品牌内容
        List<FirstMiddleBean.DataBean._$88011Bean.TagBeanXXXXXXXX> tag8= data.get(15).get_$88011().getTag();
        for (int i = tag7.size()-1 ; i >=0; i--) {
            String imag6 = imag + tag8.get(i).getPicUrl();
            LinearLayout layout = new LinearLayout(getContext());
            layout.setPadding(3, 3, 3, 3);
            layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
            //图片
            ImageView imageView = new ImageView(getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100,80);
            imageView.setLayoutParams(params);
            Glide.with(getContext()).load(tag8).into(imageView);
            //价格
            TextView tv = new TextView(getContext());
            tv.setGravity(Gravity.CENTER);
            tv.setText("$50.00");
            tv.setTextColor(Color.RED);
            layout.addView(imageView);
            layout.addView(tv);
            middlefragmentLilayoutBrand3.addView(layout);
        }


        //第四个品牌

        String imag8= imag3+ data.get(16).get_$88010().getTag().get(0).getPicUrl();
        Glide.with(getContext()).load(imag8).into(middlefragmentIvBrand4);
        //第二个品牌内容
        List<FirstMiddleBean.DataBean._$88011Bean.TagBeanXXXXXXXX> tag9= data.get(17).get_$88011().getTag();
        for (int i = tag7.size()-1 ; i >=0; i--) {
            String imag6 = imag + tag9.get(i).getPicUrl();
            LinearLayout layout = new LinearLayout(getContext());
            layout.setPadding(3, 3, 3, 3);
            layout.setOrientation(LinearLayout.VERTICAL);// 所有组件垂直摆放
            //图片
            ImageView imageView = new ImageView(getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(100,80);
            imageView.setLayoutParams(params);
            Glide.with(getContext()).load(tag9).into(imageView);
            //价格
            TextView tv = new TextView(getContext());
            tv.setGravity(Gravity.CENTER);
            tv.setText("$50.00");
            tv.setTextColor(Color.RED);
            layout.addView(imageView);
            layout.addView(tv);
            middlefragmentLilayoutBrand4.addView(layout);
        }




    }

    @Override
    public void getDataOnFailed(String failed) {

    }
}

//活动
//<LinearLayout
//android:layout_width="match_parent"
//        android:orientation="vertical"
//        android:layout_height="wrap_content">
//<ImageView
//android:id="@+id/middlefragment_iv_action1"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content" />
//<TextView
//android:textSize="20sp"
//        android:textColor="#000000"
//        android:id="@+id/middlefragment_tv_action1_name"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content" />
//<TextView
//android:textSize="15sp"
//        android:textColor="@color/text_hui"
//        android:id="@+id/middlefragment_tv_action1_desc"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content" />
//<LinearLayout
//android:gravity="right"
//        android:layout_width="match_parent"
//        android:orientation="horizontal"
//        android:layout_height="wrap_content">
//<TextView
//android:textSize="12sp"
//        android:textColor="#FF0033"
//        android:id="@+id/middlefragment_tv_action1_price"
//        android:layout_marginLeft="4dp"
//        android:layout_weight="1"
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content" />
//
//<Button
//android:id="@+id/middlefragment_btn_action1_buy"
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:layout_marginRight="4dp"
//        android:textColor="#ffffff"
//        android:background="#FF5577"
//        android:text="立即开团"/>
//</LinearLayout>
//<LinearLayout
//
//android:orientation="horizontal"
//        android:background="#eeeeee"
//        android:layout_width="match_parent"
//        android:layout_height="2dp"></LinearLayout>
//<TextView
//android:id="@+id/middlefragment_tv_action1_more"
//        android:paddingTop="2dp"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:gravity="center"
//        android:textColor="#000000"
//        android:text="查看更多 >"
//        />
//</LinearLayout>
//<!--空格-->
//<LinearLayout
//android:orientation="vertical"
//        android:background="#EEEEEE"
//        android:layout_width="match_parent"
//        android:layout_height="10dp"></LinearLayout>
//
//
//<!--活动二-->
//<LinearLayout
//android:layout_width="match_parent"
//        android:orientation="vertical"
//        android:layout_height="wrap_content">
//<ImageView
//android:id="@+id/middlefragment_iv_action2"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content" />
//<TextView
//android:textSize="20sp"
//        android:textColor="#000000"
//        android:id="@+id/middlefragment_tv_action2_name"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content" />
//<TextView
//android:textSize="15sp"
//        android:textColor="@color/text_hui"
//        android:id="@+id/middlefragment_tv_action2_desc"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content" />
//<LinearLayout
//android:gravity="right"
//        android:layout_width="match_parent"
//        android:orientation="horizontal"
//        android:layout_height="wrap_content">
//<TextView
//android:textSize="12sp"
//        android:textColor="#FF0033"
//        android:id="@+id/middlefragment_tv_action2_price"
//        android:layout_marginLeft="4dp"
//        android:layout_weight="1"
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content" />
//
//<Button
//android:id="@+id/middlefragment_btn_action2_buy"
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:layout_marginRight="4dp"
//        android:textColor="#ffffff"
//        android:background="#FF5577"
//        android:text="立即开团"/>
//</LinearLayout>
//<LinearLayout
//android:orientation="horizontal"
//        android:background="#eeeeee"
//        android:layout_width="match_parent"
//        android:layout_height="2dp"></LinearLayout>
//<TextView
//android:id="@+id/middlefragment_tv_action2_more"
//        android:paddingTop="2dp"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:gravity="center"
//        android:textColor="#000000"
//        android:text="查看更多 >"
//        />
//</LinearLayout>