package com.bawei.wangxueshi.fengzhuangmvpandretrofit.widget;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;

/**
 * Created by muhanxi on 17/6/19.
 */
//底部导航的布局
public class ButtomLayout extends LinearLayout {

    public ButtomLayout(Context context) {
        this(context,null);
    }

    public ButtomLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ButtomLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view =  LayoutInflater.from(context).inflate(R.layout.tab_layout,this);
        //找到控件
        RadioGroup radioGroup = (RadioGroup)  view.findViewById(R.id.tab_radiogroup);
        RadioButton radioButtonFirst = (RadioButton) view.findViewById(R.id.radiobutton_home);
        RadioButton radioButtonSecond = (RadioButton) view.findViewById(R.id.radiobutton_discover);
        RadioButton radioButtonThird = (RadioButton) view.findViewById(R.id.radiobutton_feed);
        RadioButton radioButtonFourth = (RadioButton) view.findViewById(R.id.radiobutton_me);


         //监听事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radiobutton_home:
                        setListener(0);
                        break;
                    case R.id.radiobutton_discover:
                        setListener(1);
                        break;
                    case R.id.radiobutton_feed:
                        setListener(2);
                        break;
                    case R.id.radiobutton_me:
                        setListener(3);
                        break;
                }
            }
        });
    }
//选择哪个了  //这里判断了listener 是否为空，在逻辑上更加严谨
    public void setListener(int index){
        if(listener != null){
            listener.onSelect(index);
        }
    }


//定义接口进行 与TabActivity 的沟通
    public interface OnSelectListener {
        public void onSelect(int index);
    }

    public OnSelectListener listener ;

    public void setOnSelectListener(OnSelectListener listener){
        this.listener = listener ;
    }











}