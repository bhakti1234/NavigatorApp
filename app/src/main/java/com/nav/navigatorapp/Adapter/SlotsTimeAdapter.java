package com.nav.navigatorapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nav.navigatorapp.R;
import com.nav.navigatorapp.pojo.Slots;
import com.nav.navigatorapp.pojo.SlotsDay;

import java.util.ArrayList;

public class SlotsTimeAdapter extends RecyclerView.Adapter<SlotsTimeAdapter.MyViewHolder> {

        Context context;
        Activity activity;
        int row_pos;
        int size,width;
        Slots slots;
        TimeAdapter timeAdapter;


    public SlotsTimeAdapter(int width,int size,Slots slots, Context context, Activity activity)
        {
            this.slots=slots;
            this.size=size;
            this.context=context;
            this.activity=activity;
            this.width=width;
        }
        @NonNull
        @Override
        public SlotsTimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.slots_time_row_item,viewGroup,false);

            return new SlotsTimeAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final SlotsTimeAdapter.MyViewHolder myViewHolder, final int i) {
            if (slots!=null) {
                switch (i) {
                    case 0:
                        myViewHolder.time_tv.setText("Morning");
                        myViewHolder.slots_tv.setText(String.valueOf(slots.getMorning().size()) + "Slots Available");
                        timeAdapter=new TimeAdapter(width,slots.getMorning(),context,activity);
                        myViewHolder.time_recyclerview.setAdapter(timeAdapter);
                        timeAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        myViewHolder.time_tv.setText("Afternoon");
                        myViewHolder.slots_tv.setText(String.valueOf(slots.getAfternoon().size()) + "Slots Available");
                        timeAdapter=new TimeAdapter(width,slots.getAfternoon(),context,activity);
                        myViewHolder.time_recyclerview.setAdapter(timeAdapter);
                        timeAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        myViewHolder.time_tv.setText("Evening");
                        myViewHolder.slots_tv.setText(String.valueOf(slots.getEvening().size()) + "Slots Available");
                        timeAdapter=new TimeAdapter(width,slots.getEvening(),context,activity);
                        myViewHolder.time_recyclerview.setAdapter(timeAdapter);
                        timeAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        myViewHolder.time_tv.setText("Night");
                        myViewHolder.slots_tv.setText(String.valueOf(slots.getNight().size()) + "Slots Available");
                        timeAdapter=new TimeAdapter(width,slots.getNight(),context,activity);
                        myViewHolder.time_recyclerview.setAdapter(timeAdapter);
                        timeAdapter.notifyDataSetChanged();
                        break;
                }
            }




        }

        @Override
        public int getItemCount() {
            return size;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView time_tv,slots_tv;
            LinearLayout day_linear;
            RecyclerView time_recyclerview;
//        Button pricebutton;

            public MyViewHolder(View view) {
                super(view);
                time_tv=view.findViewById(R.id.time_tv);
                slots_tv=view.findViewById(R.id.slots_tv);
                day_linear=view.findViewById(R.id.day_linear);
                time_recyclerview=view.findViewById(R.id.time_recyclerview);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(context,4);
                time_recyclerview.setLayoutManager(gridLayoutManager);
            }
        }
}
