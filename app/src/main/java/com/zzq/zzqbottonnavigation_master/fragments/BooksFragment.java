package com.zzq.zzqbottonnavigation_master.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzq.zzqbottonnavigation_master.R;

/**
 * Created by 志强 on 2017.1.9.
 */

public class BooksFragment extends Fragment {

    public static BooksFragment newInstance(String param1, String param2) {
        BooksFragment fragment = new BooksFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        args.putString("agrs2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BooksFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView message = (TextView) view.findViewById(R.id.message);
        TextView scrollable_text = (TextView) view.findViewById(R.id.scrollable_text);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        String agrs2 = bundle.getString("agrs2");
        message.setText(agrs1);
        scrollable_text.setText(agrs2);
        return view;

    }
}
