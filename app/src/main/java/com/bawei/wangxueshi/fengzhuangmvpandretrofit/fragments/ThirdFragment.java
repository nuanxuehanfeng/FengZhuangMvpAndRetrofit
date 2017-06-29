package com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.adapter.ThirdRecyclerAdapter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.ShopBean;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.utils.StringUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    @BindView(R.id.thirdfragment_recycle)
    RecyclerView thirdfragmentRecycle;
    @BindView(R.id.thirdfragment_iv_selects)
    ImageView thirdfragmentIvSelects;
    @BindView(R.id.thirdfragment_tv_price)
    TextView thirdfragmentTvPrice;
    @BindView(R.id.thirdfragment_btn_buy)
    Button thirdfragmentBtnBuy;
    @BindView(R.id.thirdfragment_tv_edit)
    TextView thirdfragmentTvEdit;
    private Unbinder bind;
    private Gson gson = new Gson();

    List<ShopBean.OrderDataBean.CartlistBean> list = new ArrayList<>();
    private ThirdRecyclerAdapter adapter;

    private boolean isSelectss = true;
    private boolean isEdit =false;


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        bind = ButterKnife.bind(this, view);
        try {
            InputStream open = getContext().getAssets().open("shop.json");

            String data = StringUtils.convertStreamToString(open);
            ShopBean shopBean = gson.fromJson(data, ShopBean.class);
            List<ShopBean.OrderDataBean> orderData = shopBean.getOrderData();
            //整合数据
            for (int i = 0; i < orderData.size(); i++) {
                list.addAll(list.size(), orderData.get(i).getCartlist());
            }
            thirdfragmentRecycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            adapter = new ThirdRecyclerAdapter(list, getContext());
            thirdfragmentRecycle.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //钱
        getMoney(list);
        //全选
        isSelects(list);

//全选的监听事件
        thirdfragmentIvSelects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSe = !isSelectss;
                if (isSe == true) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setShopSelect(true);
                        list.get(i).setStoreSelect(true);
                    }
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setShopSelect(false);
                        list.get(i).setStoreSelect(false);
                    }
                }
                //改变全选图标
                isSelects(list);
                //改变价格
                getMoney(list);
                adapter.notifyDataSetChanged();
            }
        });
        //编辑的监听
        thirdfragmentTvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEdit=!isEdit;
                if(isEdit==true){
                    thirdfragmentTvEdit.setText("完成");
                    thirdfragmentBtnBuy.setText("删除");
                    //删除
                    thirdfragmentBtnBuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            boolean selects = isSelects(list);
                            
                            if(selects){

                                list.clear();
                            //    thirdfragmentIvSelects.setImageDrawable(getContext().getResources().getDrawable(R.drawable.cpt_filter_check_off));
                            }
                           else{
                            for(int i=0;i<list.size();i++) {
                                if(list.get(i).isShopSelect()){

                                      list.remove(i);//为什么全选时；不用了这个，不是全选却能用呢
                                }
                            }
                            }
                              isSelects(list);
                            getMoney(list);
                            adapter.notifyDataSetChanged();
                        }
                    });


                }
                else{
                    thirdfragmentTvEdit.setText("编辑");
                    thirdfragmentBtnBuy.setText("去结算");
                    adapter.notifyDataSetChanged();
                }


            }
        });

//适配器的监听  全选
        adapter.setOnItemSelectsListener(new ThirdRecyclerAdapter.OnItemSelectsListener() {
            @Override
            public void onItemSelects(List<ShopBean.OrderDataBean.CartlistBean> list) {
                isSelects(list);
            }
        });

//适配器的监听  钱
        adapter.setOnMoneyChangeListener(new ThirdRecyclerAdapter.OnItemClickMoneyListener() {
            @Override
            public void onItemMoneyChange(List<ShopBean.OrderDataBean.CartlistBean> list) {
                getMoney(list);
            }
        });
        return view;

    }

    private void getMoney(List<ShopBean.OrderDataBean.CartlistBean> list) {
        //总价
        float mTotlaPrice = 0f;
        //个数
        int mTotalNum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isShopSelect()) {
                mTotlaPrice += list.get(i).getPrice() * list.get(i).getCount();
                //数量
                mTotalNum += list.get(i).getCount();
            }
        }
        thirdfragmentTvPrice.setText("合计：￥" + mTotlaPrice + "");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }


    //是否全选
    public boolean isSelects(List<ShopBean.OrderDataBean.CartlistBean> list) {
        if(list==null||list.size()==0){
            thirdfragmentIvSelects.setImageDrawable(getContext().getResources().getDrawable(R.drawable.cpt_filter_check_off));
            isSelectss = false;
            return isSelectss;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isShopSelect()) {
                thirdfragmentIvSelects.setImageDrawable(getContext().getResources().getDrawable(R.drawable.cpt_filter_check_off));
                isSelectss = false;
                return isSelectss;
            }
        }
        thirdfragmentIvSelects.setImageDrawable(getContext().getResources().getDrawable(R.drawable.cpt_filter_check_on));
        isSelectss = true;
        return isSelectss;
    }


}
