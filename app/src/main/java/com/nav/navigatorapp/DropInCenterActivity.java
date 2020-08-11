package com.nav.navigatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.nav.navigatorapp.Adapter.SlotsDayAdapter;
import com.nav.navigatorapp.Adapter.SlotsTimeAdapter;
import com.nav.navigatorapp.listeners.DayClickedListener;
import com.nav.navigatorapp.pojo.Slots;
import com.nav.navigatorapp.pojo.SlotsDay;

import java.util.ArrayList;

public class DropInCenterActivity extends AppCompatActivity implements View.OnClickListener, DayClickedListener {

    MaterialCardView option_card;
    LinearLayout search_linear,nav_time_details_linear;
    RecyclerView days_recyclerview;
    RecyclerView slots_time_recyclerview;
    ArrayList<SlotsDay> slotsDaysList;
    TextView day_tv;
    SlotsDayAdapter slotsDayAdapter;
    Activity mActivity;
    ArrayList<String> morning,afternoon,evening,night;
    ArrayList<Slots> slotsList;
    SlotsTimeAdapter slotsTimeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_in_center);
        init();
    }

    public void init()
    {
        option_card=findViewById(R.id.option_card);
        search_linear=findViewById(R.id.search_linear);
        nav_time_details_linear=findViewById(R.id.nav_time_details_linear);
        option_card.setOnClickListener(this);

    }

    void initNavDetailsLinear()
    {
        days_recyclerview=findViewById(R.id.days_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        days_recyclerview.setLayoutManager(linearLayoutManager);
        slots_time_recyclerview=findViewById(R.id.slots_time_recyclerview);
        LinearLayoutManager linearManager=new LinearLayoutManager(this);
        linearManager.setOrientation(RecyclerView.VERTICAL);
        slots_time_recyclerview.setLayoutManager(linearManager);
        slotsDaysList=new ArrayList<>();
        day_tv=findViewById(R.id.day_tv);
        morning=new ArrayList<>();
        afternoon=new ArrayList<>();
        evening=new ArrayList<>();
        night=new ArrayList<>();
        slotsList=new ArrayList<>();
    }
    void initData()
    {
        slotsDaysList.add(new SlotsDay("Fri 10 Jul","No Slots Available"));
        slotsDaysList.add(new SlotsDay("Sat 11 Jul","No Slots Available"));
        slotsDaysList.add(new SlotsDay("Sun 12 Jul","57 Slots Available"));
        slotsDaysList.add(new SlotsDay("Mon 13 Jul","66 Slots Available"));
        slotsDayAdapter=new SlotsDayAdapter(slotsDaysList,this,this);
        days_recyclerview.setAdapter(slotsDayAdapter);
        slotsDayAdapter.notifyDataSetChanged();




    }

    public void updateView()
    {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.option_card:
                search_linear.setVisibility(View.GONE);
                nav_time_details_linear.setVisibility(View.VISIBLE);
                initNavDetailsLinear();
                initData();
        }
    }




    @Override
    public void onResume()
    {
        super.onResume();
        search_linear.setVisibility(View.VISIBLE);
        nav_time_details_linear.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onDayClicked(String day) {
        Slots slots = null;
        day_tv.setText(day);
        if (day.equals("Sun 12 Jul") || day.equals("Mon 13 Jul")) {
            slots = new Slots(day);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;
            int widthpx = width / 4;
            Log.d("width", String.valueOf(width));
            Log.d("widthpx", String.valueOf(widthpx));
            int w = widthpx - 4;
            Log.d("widthfor", String.valueOf(w));
            slotsTimeAdapter = new SlotsTimeAdapter(w, 4, slots,this, this);
            slots_time_recyclerview.setAdapter(slotsTimeAdapter);
            slotsTimeAdapter.notifyDataSetChanged();

    }
}
