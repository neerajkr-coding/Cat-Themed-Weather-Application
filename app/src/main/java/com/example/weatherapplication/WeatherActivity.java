package com.example.weatherapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapplication.databinding.ActivityWeatherBinding;
import com.example.weatherapplication.models.Day;
import com.example.weatherapplication.models.ViewModel;
import com.example.weatherapplication.models.Weather;

public class WeatherActivity extends AppCompatActivity {

    String place;

    ViewModel viewModel;

    ActivityWeatherBinding activityWeatherBinding;

    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        activityWeatherBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather);

        Intent i = getIntent();
        place = i.getStringExtra("Loc");


        //Configuring RecyclerView
        recyclerView = activityWeatherBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);


        viewModel.getMutableLiveDataWeather(place).observe(this, new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {



                activityWeatherBinding.setWeather(weather);
                Day d = weather.getDayList().get(0);
                activityWeatherBinding.setDay(d);

                adapter.setDayArrayList(weather.getDayList());

            }
        });


    }
}