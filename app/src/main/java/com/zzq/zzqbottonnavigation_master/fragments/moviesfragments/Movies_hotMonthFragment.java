package com.zzq.zzqbottonnavigation_master.fragments.moviesfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzq.zzqbottonnavigation_master.R;

/**
 * Created by 志强 on 2017.1.11.
 */

public class Movies_hotMonthFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_hotmonth, container, false);
        return view;
    }
}
