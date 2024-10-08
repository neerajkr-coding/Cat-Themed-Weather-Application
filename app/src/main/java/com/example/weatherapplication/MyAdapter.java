package com.example.weatherapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapplication.databinding.DayItemBinding;
import com.example.weatherapplication.models.Day;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Day> dayArrayList;

    public void setDayArrayList(ArrayList<Day> dayArrayList) {
        this.dayArrayList = dayArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        DayItemBinding dayItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.day_item,
                parent,
                false
        );

        return new ViewHolder(dayItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Day d = dayArrayList.get(position);

        holder.dayItemBinding.setDay(d);
    }

    @Override
    public int getItemCount() {
        if(dayArrayList == null){

            return 0;
        }
        return dayArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        DayItemBinding dayItemBinding;

        public ViewHolder(DayItemBinding dayItemBinding) {
            super(dayItemBinding.getRoot());
            this.dayItemBinding = dayItemBinding;
        }
    }

}
