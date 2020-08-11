package com.nav.navigatorapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nav.navigatorapp.R;
import com.nav.navigatorapp.pojo.Slots;

import java.util.ArrayList;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.MyViewHolder> {

        Context context;
        Activity activity;
        int row_pos=-1;
        int size;
        ArrayList<String> timeList;
        int width;


    public TimeAdapter(int width,ArrayList<String> timeList, Context context, Activity activity)
        {
            this.timeList=timeList;
            this.context=context;
            this.activity=activity;
            this.width=width;
        }
        @NonNull
        @Override
        public TimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.time_row_item,viewGroup,false);

            return new TimeAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final TimeAdapter.MyViewHolder myViewHolder, final int i) {
            String str=timeList.get(i);
            String[] str_arr=str.split(" ",2);
            myViewHolder.time_tv.setText(str_arr[0]);
            myViewHolder.t_tv.setText(str_arr[1]);
            Log.d("width",String.valueOf(width));
            int height=(int)(width/4);
            int h=height+height+height;
            myViewHolder.time_linear.setLayoutParams(new RelativeLayout.LayoutParams(width,h));
            myViewHolder.time_linear.setGravity(Gravity.CENTER);
            Log.d("height",String.valueOf(myViewHolder.time_tv.getLayoutParams().height));
            RelativeLayout.LayoutParams params=(RelativeLayout.LayoutParams) myViewHolder.time_linear.getLayoutParams();
            params.setMargins(2,2,2,2);
            myViewHolder.time_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_pos=i;
                    notifyDataSetChanged();
                }
            });
            Log.d("row_pos",String.valueOf(row_pos)+" "+String.valueOf(i));
            if (row_pos==i)
            {
                myViewHolder.front_linear.setLayoutParams(new RelativeLayout.LayoutParams(width,h));
                myViewHolder.front_linear.setGravity(Gravity.CENTER);
                RelativeLayout.LayoutParams bookparams=(RelativeLayout.LayoutParams) myViewHolder.front_linear.getLayoutParams();
                bookparams.setMargins(2,2,2,2);
                myViewHolder.front_linear.setVisibility(View.VISIBLE);
            }
            else
            {
                myViewHolder.front_linear.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public int getItemCount() {
            return timeList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView time_tv,t_tv;
            RelativeLayout time_linear,front_linear;


            public MyViewHolder(View view) {
                super(view);
                time_tv=view.findViewById(R.id.time_tv);
                t_tv=view.findViewById(R.id.t_tv);
                time_linear=view.findViewById(R.id.time_linear);
                front_linear=view.findViewById(R.id.front_linear);
            }
        }
}
