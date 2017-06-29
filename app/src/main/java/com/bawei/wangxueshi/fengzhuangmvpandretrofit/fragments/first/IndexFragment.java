package com.bawei.wangxueshi.fengzhuangmvpandretrofit.fragments.first;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.wangxueshi.fengzhuangmvpandretrofit.R;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.adapter.IndexIrecycleAdapter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.base.BaseMvpFragment;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.bean.FirstShangXinBean;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.presenter.IndexFragmentPresenter;
import com.bawei.wangxueshi.fengzhuangmvpandretrofit.view.IndexFragmentView;
import com.google.gson.Gson;

import java.util.List;

public class IndexFragment extends BaseMvpFragment<IndexFragmentView,IndexFragmentPresenter>  implements IndexFragmentView {

    private static final String ARG_PARAM1 = "param1";
    private int mParam1;
    private RecyclerView recycler;
    private Gson gson;
    private String path;

    @Override
    public IndexFragmentPresenter initPresenter() {
        return new IndexFragmentPresenter();
    }
    public IndexFragment() {
    }
    public static IndexFragment newInstance(int param1) {
        IndexFragment fragment = new IndexFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_index, container, false);
        initView(view1);
        gson = new Gson();
        return view1 ;
    }
    private void initView(View view1) {
        recycler = (RecyclerView) view1.findViewById(R.id.indexfragment_recycler);


        Bundle arguments = getArguments();
        path = arguments.getString("LinkUrl");


        presenter.getData(path);

    }
    @Override
    public void getDataOnSuccess(List<FirstShangXinBean.DataBean> data) {
        recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        //上新界面
        IndexIrecycleAdapter indexIrecycleAdapter = new IndexIrecycleAdapter(getContext());
       indexIrecycleAdapter.setData(data);

        recycler.setAdapter(indexIrecycleAdapter);



    }

    @Override
    public void getDataOnFailed(String failed) {

    }
}
