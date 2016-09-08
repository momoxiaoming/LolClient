package com.andorid.lolclient.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andorid.lolclient.R;


public class LeftFragment extends Fragment {

    public LeftFragment() {
        // Required empty public constructor
    }

    public static LeftFragment newInstance() {
        LeftFragment fragment = new LeftFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false);
    }
}
