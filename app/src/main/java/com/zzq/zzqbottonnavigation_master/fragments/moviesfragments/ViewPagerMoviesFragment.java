package com.zzq.zzqbottonnavigation_master.fragments.moviesfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzq.zzqbottonnavigation_master.R;
import com.zzq.zzqbottonnavigation_master.adapter.Tab_Fragment_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 志强 on 2017.1.11.
 */

public class ViewPagerMoviesFragment extends Fragment {
    public static final String FRAGMENT_TAG = "moviesfragment";
    private TabLayout tb_sliding_tabs;
    private ViewPager vp_viewPager;
    private Tab_Fragment_Adapter tab_fragment_adapter;
    private List<Fragment> list_Fragment;//
    private List<String> list_Title;
    //Fragment
    private Movies_hotRecommendFragment hotRecommendFragment;       //热门推荐fragment
    private Movies_hotCollectionFragment hotCollectionFragment;     //热门收藏fragment
    private Movies_hotMonthFragment hotMonthFragment;               //本月热榜fragment
    private Movies_hotToday hotToday;                                //今日热榜

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //undefined
        View view = inflater.inflate(R.layout.fragment_viewpager_movies, container, false);
        initControls(view);
        return view;
    }

    /**
     * 初始化组件
     *
     * @param view
     */
    private void initControls(View view) {
        //实例化组件
        tb_sliding_tabs = (TabLayout) view.findViewById(R.id.tb_sliding_tabs);
        vp_viewPager = (ViewPager) view.findViewById(R.id.vp_viewPager);
        //实例化Fragment
        hotRecommendFragment = new Movies_hotRecommendFragment();
        hotCollectionFragment = new Movies_hotCollectionFragment();
        hotMonthFragment = new Movies_hotMonthFragment();
        hotToday = new Movies_hotToday();
        //Fragment add List
        list_Fragment = new ArrayList<>();
        list_Fragment.add(hotRecommendFragment);
        list_Fragment.add(hotCollectionFragment);
        list_Fragment.add(hotMonthFragment);
        list_Fragment.add(hotToday);
        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_Title = new ArrayList<>();
        list_Title.add("热门推荐");
        list_Title.add("热门收藏");
        list_Title.add("本月热榜");
        list_Title.add("今日热榜");
        //设置TabLayout的模式
        tb_sliding_tabs.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tb_sliding_tabs.addTab(tb_sliding_tabs.newTab().setText(list_Title.get(0)));
        tb_sliding_tabs.addTab(tb_sliding_tabs.newTab().setText(list_Title.get(1)));
        tb_sliding_tabs.addTab(tb_sliding_tabs.newTab().setText(list_Title.get(2)));
        tb_sliding_tabs.addTab(tb_sliding_tabs.newTab().setText(list_Title.get(3)));
        tab_fragment_adapter = new Tab_Fragment_Adapter(getActivity().getSupportFragmentManager(), list_Fragment, list_Title);
        //viewpager加载adapter
        vp_viewPager.setAdapter(tab_fragment_adapter);

        //TabLayout加载viewpager
        tb_sliding_tabs.setupWithViewPager(vp_viewPager);
        vp_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tb_sliding_tabs));
    }
}
