package com.example.lenovo.playandroid.fragments.bothurdle.items;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.playandroid.R;
import com.example.lenovo.playandroid.adapter.ItemsAdapter;
import com.example.lenovo.playandroid.base.fragment.BaseFragment;
import com.example.lenovo.playandroid.bean.yxbean.ProjectClassify;
import com.example.lenovo.playandroid.presenter.Presenter;
import com.example.lenovo.playandroid.view.IView;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends BaseFragment<IView, Presenter<IView>> implements IView {


    @BindView(R.id.project_tab_layout)
    SlidingTabLayout mProjectTabLayout;
    @BindView(R.id.project_divider)
    View mProjectDivider;
    @BindView(R.id.project_viewpager)
    ViewPager mProjectViewpager;
    @BindView(R.id.normal_view)
    LinearLayout mNormalView;
    Unbinder unbinder;
    Unbinder unbinder1;
    private View view;

    public ItemsFragment() {
        // Required empty public constructor
    }

    @Override
    protected int creatrLayoutId() {
        return R.layout.fragment_items;
    }

    @Override
    protected void initData() {
        mPresenter.getDataP("");
    }

    @Override
    public void show(Object o) {
        ProjectClassify projectClassify = (ProjectClassify) o;
        List<ProjectClassify.DataBean> data = projectClassify.getData();
        Log.e("yx", "show: " + data.get(0).getName());
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            ClassifyFragment frag = ClassifyFragment.getFrag(data.get(i).getId(), data.get(i).getName());
            fragments.add(frag);
        }
        Log.e("yx", "show: " + fragments.size());
        ItemsAdapter itemsAdapter = new ItemsAdapter(getChildFragmentManager(), data, fragments);
        mProjectViewpager.setAdapter(itemsAdapter);
        mProjectTabLayout.setViewPager(mProjectViewpager);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected Presenter<IView> createPresenter() {
        return new Presenter<>();
    }



    @OnClick(R.id.normal_view)
    public void onViewClicked() {
        Toast.makeText(mContext, "点击", Toast.LENGTH_SHORT).show();
    }
}
