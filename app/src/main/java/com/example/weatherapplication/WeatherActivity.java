package com.example.weatherapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapplication.databinding.ActivityWeatherBinding;
import com.example.weatherapplication.models.Day;
import com.example.weatherapplication.models.ViewModel;
import com.example.weatherapplication.models.Weather;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class WeatherActivity extends AppCompatActivity {

    String place;

    ViewModel viewModel;

    ActivityWeatherBinding activityWeatherBinding;

    RecyclerView recyclerView;
    MyAdapter adapter;

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        activityWeatherBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather);

        Intent i = getIntent();
        place = i.getStringExtra("Loc");


        //Configuring RecyclerView
        recyclerView = activityWeatherBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        constraintLayout = activityWeatherBinding.main;


        viewModel.getMutableLiveDataWeather(place).observe(this, new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {

                Day d = weather.getDayList().get(0);
                setWeatherIcon(d);
                convertDate(d.getDate());



                activityWeatherBinding.setWeather(weather);
                d.getDate();
                activityWeatherBinding.setDay(d);

                adapter.setDayArrayList(weather.getDayList());

            }
        });
    }


    private void setWeatherIcon(Day d){
        int img;
        int bg;
        String condition = d.getCondition();

        if(condition.equals("Clear")){
                img = R.drawable.hot;
                bg = R.drawable.hotbg;

        }else if(condition.equals("Overcast")){
                img = R.drawable.cloud;
                bg = R.drawable.nighbg;

        }else if(condition.equals("Rain")){
            img = R.drawable.raining;
            bg = R.drawable.clearbg;

        }else{
            img = R.drawable.cloudy;
            bg = R.drawable.nighbg;
        }

        if(d.getTemp()<17){
            img = img = R.drawable.cold;
            bg = R.drawable.coldbg;
        }

        activityWeatherBinding.weatherIcon.setImageResource(img);
        activityWeatherBinding.main.setBackgroundResource(bg);
    }

    private void convertDate(String date){
//        2024/10/08

//        Getting and parsing date
        String[] months = {"January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"};

        Integer m = Integer.parseInt(date.substring(5,7));

        String curr_month = months[m-1];

        String curr_date = date.substring(8,10);
        if(curr_date.charAt(0) == '0'){
            curr_date =""+ curr_date.charAt(1);
        }
        String curr_weekday = getWeekday(date);
        String full_date = curr_weekday+" - "+curr_date+" "+curr_month;



        //        Greeting
        Calendar calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String greeting="";


        if (hour >= 0 && hour < 12) {
            greeting = "Good Morning!";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon!";
        } else {
            greeting = "Good Evening!";
        }

        activityWeatherBinding.DayDate.setText(full_date);
        activityWeatherBinding.Greeting.setText(greeting);
    }

    private String getWeekday(String date) {
        // Create a SimpleDateFormat object with the expected date format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String weekday = "";

        try {
            // Parse the date string into a Date object
            Date dateObj = sdf.parse(date);

            // Use a Calendar instance to get the day of the week
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObj);

            // Get the weekday as a string
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
            weekday = dayFormat.format(dateObj);

        } catch (Exception e) {
            e.printStackTrace(); // Handle the parsing error
        }

        return weekday;
    }
}