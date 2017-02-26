package com.zzq.zzqbottonnavigation_master.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzq.zzqbottonnavigation_master.R;
import com.zzq.zzqbottonnavigation_master.fragments.gamesfragments.ViewPagerTabFragmentParentFragment;

/**
 * Created by 志强 on 2017.1.9.
 */

public class GamesFragment extends Fragment {

    public static GamesFragment newInstance(String param1, String param2) {
        GamesFragment fragment = new GamesFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        args.putString("agrs2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    public GamesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games, container, false);
        FragmentManager fm = getChildFragmentManager();
//        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentByTag(ViewPagerTabFragmentParentFragment.FRAGMENT_TAG) == null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragmentthree, new ViewPagerTabFragmentParentFragment(),
                    ViewPagerTabFragmentParentFragment.FRAGMENT_TAG);
            ft.commit();
            fm.executePendingTransactions();
        }
        return view;

    }
}
