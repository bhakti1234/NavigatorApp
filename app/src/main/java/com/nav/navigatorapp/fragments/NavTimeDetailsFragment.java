package com.nav.navigatorapp.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nav.navigatorapp.Adapter.SlotsDayAdapter;
import com.nav.navigatorapp.Adapter.SlotsTimeAdapter;
import com.nav.navigatorapp.R;
import com.nav.navigatorapp.listeners.DayClickedListener;
import com.nav.navigatorapp.pojo.Slots;
import com.nav.navigatorapp.pojo.SlotsDay;

import java.util.ArrayList;
import java.util.Arrays;

public class NavTimeDetailsFragment extends Fragment {
    protected View mView;
    RecyclerView days_recyclerview;
    RecyclerView slots_time_recyclerview;
    ArrayList<SlotsDay> slotsDaysList;
    TextView day_tv;
    SlotsDayAdapter slotsDayAdapter;
    Activity mActivity;
    ArrayList<String> morning,afternoon,evening,night;
    ArrayList<Slots> slotsList;
    SlotsTimeAdapter slotsTimeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_nav_time_details, container, false);
        init();
//        initData();
        return mView;
    }

    void init()
    {
        days_recyclerview=mView.findViewById(R.id.days_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        days_recyclerview.setLayoutManager(linearLayoutManager);
        slots_time_recyclerview=mView.findViewById(R.id.slots_time_recyclerview);
        LinearLayoutManager linearManager=new LinearLayoutManager(getActivity());
        linearManager.setOrientation(RecyclerView.VERTICAL);
        slots_time_recyclerview.setLayoutManager(linearManager);
        slotsDaysList=new ArrayList<>();
        day_tv=mView.findViewById(R.id.day_tv);
        mActivity=getActivity();
        morning=new ArrayList<>();
        afternoon=new ArrayList<>();
        evening=new ArrayList<>();
        night=new ArrayList<>();
        slotsList=new ArrayList<>();
    }
//    void initData()
//    {
//        slotsDaysList.add(new SlotsDay("Fri 10 Jul","No Slots Available"));
//        slotsDaysList.add(new SlotsDay("Sat 11 Jul","No Slots Available"));
//        slotsDaysList.add(new SlotsDay("Sun 12 Jul","57 Slots Available"));
//        slotsDaysList.add(new SlotsDay("Mon 13 Jul","66 Slots Available"));
//        slotsDayAdapter=new SlotsDayAdapter(slotsDaysList,getActivity(),mActivity,this);
//        days_recyclerview.setAdapter(slotsDayAdapter);
//        slotsDayAdapter.notifyDataSetChanged();
//
//
//
//
//    }

//    @Override
//    public void onDayClicked(String day) {
//        Slots slots = null;
//        day_tv.setText(day);
//        if (day.equals("Sun 12 Jul") || day.equals("Mon 13 Jul")) {
//            slots = new Slots(day);
//        }
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        if (getActivity()!=null) {
//            (getActivity()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//            int height = displayMetrics.heightPixels;
//            int width = displayMetrics.widthPixels;
//            int widthpx = width / 4;
//            Log.d("width", String.valueOf(width));
//            Log.d("widthpx", String.valueOf(widthpx));
//            int w = widthpx - 4;
//            Log.d("widthfor", String.valueOf(w));
//            slotsTimeAdapter = new SlotsTimeAdapter(w, 4, slots, getActivity(), mActivity);
//            slots_time_recyclerview.setAdapter(slotsTimeAdapter);
//            slotsTimeAdapter.notifyDataSetChanged();
//        }
//    }
}
