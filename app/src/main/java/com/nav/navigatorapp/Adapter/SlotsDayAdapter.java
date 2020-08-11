package com.nav.navigatorapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nav.navigatorapp.R;
import com.nav.navigatorapp.listeners.DayClickedListener;
import com.nav.navigatorapp.pojo.SlotsDay;

import java.util.ArrayList;

public class SlotsDayAdapter extends RecyclerView.Adapter<SlotsDayAdapter.MyViewHolder> {
        ArrayList<SlotsDay> slotsDaysList;
        Context context;
        Activity activity;
        int row_pos;
        DayClickedListener listener;
    public SlotsDayAdapter(ArrayList<SlotsDay> slotsDaysList, Context context,DayClickedListener listener)
        {
            this.slotsDaysList=slotsDaysList;
            this.context=context;
            this.listener=listener;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.day_row_item,viewGroup,false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.day_tv.setText(slotsDaysList.get(i).getDay());
        myViewHolder.slot_available_tv.setText(slotsDaysList.get(i).getNumber_of_slots());
            myViewHolder.day_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_pos=i;
                    notifyDataSetChanged();
                    listener.onDayClicked(slotsDaysList.get(i).getDay());
                }
            });
                if (row_pos==i)
                {
                    myViewHolder.day_linear.setBackground(context.getDrawable(R.drawable.orange_stroke_round_bg));
                }
                else
                {
                    myViewHolder.day_linear.setBackground(context.getDrawable(R.drawable.edittext_bg_line));
                }

        }

        @Override
        public int getItemCount() {
            return slotsDaysList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView day_tv,slot_available_tv;
            LinearLayout day_linear;
//        Button pricebutton;

            public MyViewHolder(View view) {
                super(view);
                day_tv=view.findViewById(R.id.day_tv);
                slot_available_tv=view.findViewById(R.id.slot_available_tv);
                day_linear=view.findViewById(R.id.day_linear);
            }
        }

}
