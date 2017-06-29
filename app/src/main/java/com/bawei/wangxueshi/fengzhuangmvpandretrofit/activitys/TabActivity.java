package com.bawei.wangxueshi.fengzhuangmvpandretrofit.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.base.IActivity;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments.FirstFragment;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments.FourthFragment;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments.SecondFragment;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments.ThirdFragment;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.widget.ButtomLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 主导航
 */

public class TabActivity extends IActivity implements ButtomLayout.OnSelectListener {

    private ButtomLayout buttomLayout;
    private FragmentManager fragmentManager;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    //当前显示的Fragnment 索引值
    private int selectIndex;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        bind = ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        //创建
        createFragment(savedInstanceState);
        //找到控件
        buttomLayout = (ButtomLayout) findViewById(R.id.buttom_layout);
        //Radiobutton切换的方法
        buttomLayout.setOnSelectListener(this);
    }

//创建Fragment
    public void createFragment(Bundle savedInstanceState){
        //在fragmentManager中通过Tag来找到Fragment
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("FirstFragment");
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("SecondFragment");
        ThirdFragment thirdFragment = (ThirdFragment) fragmentManager.findFragmentByTag("ThirdFragment");
        FourthFragment fourthFragment = (FourthFragment) fragmentManager.findFragmentByTag("FourthFragment");
        //如果通过Tag没有找到 则创建这个Fragment
        if(firstFragment == null){
            firstFragment = new FirstFragment();
        }
        if(secondFragment == null){
            secondFragment = new SecondFragment();
        }
        if(thirdFragment == null){
            thirdFragment = new ThirdFragment();
        }
        if(fourthFragment == null){
            fourthFragment = new FourthFragment();
        }
        //将Fragmnt  添加进集合
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        fragments.add(fourthFragment);

        //这里是看是否把Fragment 在 save方法保存
        if(savedInstanceState!=null){
            // 获取上次保存的界面，并显示出来
            selectIndex=savedInstanceState.getInt("selectIndex");
        }
        else{
            //默认显示第一个
            selectIndex=0;
        }
        //显示
        switchFragment(selectIndex);
    }

//选择哪个Fragment 显示
    public void switchFragment(int pos){
        //事务
        FragmentTransaction transaction =  fragmentManager.beginTransaction() ;
        // 判断是否添加了，若没有添加，则添加进集合
        if(!fragments.get(pos).isAdded()){
            //向事务里添加Fragment 参数：占位的id,要添加的Fragment,,这个Fragnment的Tag（为类名）
            transaction.add(R.id.container,fragments.get(pos),fragments.get(pos).getClass().getSimpleName());
        }
        for(int i=0;i<fragments.size();i++){
            if(i == pos){
                //显示选择的
                transaction.show(fragments.get(pos));
            }else {
                //隐藏其他的
                transaction.hide(fragments.get(i));
            }
        }
        //事务的提交
        transaction.commit();
    }
    /**
     * 底部导航 点击 回调
     * @param index
     */
    @Override
    public void onSelect(int index) {
        selectIndex=index;
        switchFragment(selectIndex);
    }
    // 内存不足 临时保存数据
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //当内存 不足时：保存当前界面
        outState.putInt("selectIndex",selectIndex);

    }
    // 内存不足 取保存的数据
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){

           // 获取上次保存的界面，并显示出来
            switchFragment(savedInstanceState.getInt("selectIndex"));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
