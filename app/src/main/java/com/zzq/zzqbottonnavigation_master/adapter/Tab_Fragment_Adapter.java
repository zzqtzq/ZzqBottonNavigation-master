package com.zzq.zzqbottonnavigation_master.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 志强 on 2017.1.11.
 */

public class Tab_Fragment_Adapter extends FragmentPagerAdapter {
    List<Fragment> list_Fragment;
    List<String> list_Title;

    public Tab_Fragment_Adapter(FragmentManager fm, List<Fragment> mListFragment, List<String> mTitle) {
        super(fm);
        this.list_Fragment = mListFragment;
        this.list_Title = mTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return list_Fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_Title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_Title.get(position % list_Title.size());
    }
}
