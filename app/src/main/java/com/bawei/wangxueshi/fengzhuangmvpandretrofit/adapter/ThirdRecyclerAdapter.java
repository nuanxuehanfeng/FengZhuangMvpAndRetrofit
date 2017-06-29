package com.bawei.wangxueshi.fengzhuangmvpandretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/22.
 */

public class ThirdRecyclerAdapter extends RecyclerView.Adapter {

    List<ShopBean.OrderDataBean.CartlistBean> list;
    Context context;



    public ThirdRecyclerAdapter(List<ShopBean.OrderDataBean.CartlistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_thirdfragment_recycler, null);
        Holder holder = new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Holder holder1 = (Holder) holder;

        if (position > 0) {
            //是同一家店的
            if (list.get(position).getShopId() == list.get(position - 1).getShopId()) {
                holder1.adpterThirdfRecyclerLinearStoreName.setVisibility(View.GONE);
            } else {
                holder1.adpterThirdfRecyclerLinearStoreName.setVisibility(View.VISIBLE);
            }
        } else {//positon==0时
            holder1.adpterThirdfRecyclerLinearStoreName.setVisibility(View.VISIBLE);

        }

        String shopName = list.get(position).getShopName();
        holder1.adpterThirdfRecyclerTvStoreName.setText(shopName);


        String defaultPic = list.get(position).getDefaultPic();
        String productName = list.get(position).getProductName();
        int price = list.get(position).getPrice();
        final int count = list.get(position).getCount();

        holder1.adpterThirdfRecyclerTvShopName.setText(productName);
        holder1.adpterThirdfRecyclerTvShopPrice.setText("￥"+price+"");
        holder1.adpterThirdfRecyclerTvShopSum.setText(count+"");
        Glide.with(context).load(list.get(position).getDefaultPic()).into(holder1.adpterThirdfRecyclerIvShopPic);

        //商品是否选择
        boolean shopSelect = list.get(position).isShopSelect();
        if(shopSelect){
            holder1.adpterThirdfRecyclerIvShopSelect.setImageDrawable(context.getResources().getDrawable(R.drawable.cpt_filter_check_on));
        }
        else{
            holder1.adpterThirdfRecyclerIvShopSelect.setImageDrawable(context.getResources().getDrawable(R.drawable.cpt_filter_check_off));
        }

        //商店的选择
        boolean storeSelect = list.get(position).isStoreSelect();
        if(storeSelect){
            holder1.adpterThirdfRecyclerIvStoreSelect.setImageDrawable(context.getResources().getDrawable(R.drawable.cpt_filter_check_on));
        }
        else{
            holder1.adpterThirdfRecyclerIvStoreSelect.setImageDrawable(context.getResources().getDrawable(R.drawable.cpt_filter_check_off));
        }

//加减数量
        holder1.adpterThirdfRecyclerBtnShopJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setCount(list.get(position).getCount()+1);
                moneyListener.onItemMoneyChange(list);
                notifyDataSetChanged();
            }
        });
        holder1.adpterThirdfRecyclerBtnShopJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).getCount()>0){
                list.get(position).setCount(list.get(position).getCount()-1);
                 moneyListener.onItemMoneyChange(list);
                notifyDataSetChanged();}
            }
        });
        //商品选择
        holder1.adpterThirdfRecyclerIvShopSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setShopSelect(!list.get(position).isShopSelect());
                for(int i=0;i<list.size();i++){
                    for(int j=0;j<list.size();j++){
                        //这个i商店的j商品有一个是为选中的
                        if(list.get(i).getShopId()==list.get(j).getShopId()&&!list.get(j).isShopSelect()){
                            list.get(i).setStoreSelect(false);
                            break;//跳出循环
                        }
                        else{
                            list.get(i).setStoreSelect(true);
                        }
                    }
                }


                moneyListener.onItemMoneyChange(list);
                //判断是否全选
                onItemSelectsListener.onItemSelects(list);
                notifyDataSetChanged();
                notifyDataSetChanged();
            }
        });
        //商店的选择
        holder1.adpterThirdfRecyclerIvStoreSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setStoreSelect(!list.get(position).isStoreSelect());

                boolean storeSelect1 = list.get(position).isStoreSelect();
                    for(int j=0;j<list.size();j++){
                        if(list.get(position).getShopId()==list.get(j).getShopId()){
                            list.get(j).setShopSelect(storeSelect1);
                            notifyDataSetChanged();
                        }
                }
                onItemSelectsListener.onItemSelects(list);
                moneyListener.onItemMoneyChange(list);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //钱的接口
    OnItemClickMoneyListener  moneyListener;
    public  interface OnItemClickMoneyListener {
        void onItemMoneyChange( List<ShopBean.OrderDataBean.CartlistBean> list);
    }
    public void setOnMoneyChangeListener(OnItemClickMoneyListener  moneyListener){
        this.moneyListener=moneyListener;
    }
   //全选的接口
    OnItemSelectsListener onItemSelectsListener;
    public interface  OnItemSelectsListener{
       void onItemSelects(List<ShopBean.OrderDataBean.CartlistBean> list);
   }
    public void setOnItemSelectsListener(  OnItemSelectsListener onItemSelectsListener){
        this.onItemSelectsListener=onItemSelectsListener;
    }


    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.adpter_thirdf_recycler_iv_store_select)
        ImageView adpterThirdfRecyclerIvStoreSelect;
        @BindView(R.id.adpter_thirdf_recycler_tv_store_name)
        TextView adpterThirdfRecyclerTvStoreName;
        @BindView(R.id.adpter_thirdf_recycler_linear_store_name)
        LinearLayout adpterThirdfRecyclerLinearStoreName;
        @BindView(R.id.adpter_thirdf_recycler_iv_shop_select)
        ImageView adpterThirdfRecyclerIvShopSelect;
        @BindView(R.id.adpter_thirdf_recycler_iv_shop_pic)
        ImageView adpterThirdfRecyclerIvShopPic;
        @BindView(R.id.adpter_thirdf_recycler_tv_shop_name)
        TextView adpterThirdfRecyclerTvShopName;
        @BindView(R.id.adpter_thirdf_recycler_tv_shop_price)
        TextView adpterThirdfRecyclerTvShopPrice;
        @BindView(R.id.adpter_thirdf_recycler_btn_shop_jian)
        ImageView adpterThirdfRecyclerBtnShopJian;
        @BindView(R.id.adpter_thirdf_recycler_tv_shop_sum)
        TextView adpterThirdfRecyclerTvShopSum;
        @BindView(R.id.adpter_thirdf_recycler_btn_shop_jia)
        ImageView adpterThirdfRecyclerBtnShopJia;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
