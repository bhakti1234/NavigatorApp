package com.nav.navigatorapp.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.card.MaterialCardView;
import com.nav.navigatorapp.DropInCenterActivity;
import com.nav.navigatorapp.R;
import com.nav.navigatorapp.listeners.FragmentChangeListener;

public class SearchFragment extends Fragment implements View.OnClickListener {
    View mView;
    MaterialCardView option_card;
    FragmentChangeListener listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_search, container, false);
        init();
//        initData();
        return mView;
    }

    public void init()
    {
        option_card=mView.findViewById(R.id.option_card);
        option_card.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.option_card:
               listener.replaceFragment(new NavTimeDetailsFragment());
        }
    }
}
