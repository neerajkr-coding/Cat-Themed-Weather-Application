package com.example.weatherapplication.models;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.weatherapplication.R;
import com.example.weatherapplication.api.weatherServiceApi;
import com.example.weatherapplication.api.RetrofitInstance;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends AndroidViewModel {

    private List<Day> days = new ArrayList<>();
    private MutableLiveData<List<Day>> mutableLiveDataDays = new MutableLiveData<>();

    private Weather weather;
    private MutableLiveData<Weather> mutableLiveDataWeather = new MutableLiveData<>();

    private Application application;


    public ViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public MutableLiveData<Weather> getMutableLiveDataWeather(String city){

        weatherServiceApi serviceApi = RetrofitInstance.getService();

//        Log.e("IsAPINULL", " "+(serviceApi == null));

        Call<Weather> call = serviceApi
                .getWeatherData(city, application.getApplicationContext().getString(R.string.apiKey));

//        Call<Weather> call = serviceApi
//                .getWeatherData(application.getApplicationContext().getString(R.string.apiKey));


        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                Log.v("Day","Yes Called");

                Weather w = response.body();

                if(w != null && w.getDayList() != null){
                    weather = w;
                    mutableLiveDataWeather.setValue(weather);
                }

//                Log.e("Days","Method is called, Weather is Null "+ (weather == null));
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable throwable) {
                Log.e("API Error", "onFailure: " + throwable.getMessage());
            }
        });

        return mutableLiveDataWeather;
    }

    public MutableLiveData<List<Day>> getMutableLiveDataDays(String city){

        Log.e("Days","method called");

        Log.e("Days","Weather is Null 1 "+ (weather == null));


        if(weather == null){
            getMutableLiveDataWeather(city).observeForever(new Observer<Weather>() {
                @Override
                public void onChanged(Weather updatedWeather) {
                    if (updatedWeather != null && updatedWeather.getDayList() != null) {
                        Log.e("Days","observeForever Weather is Null "+ (weather == null));
                        weather = updatedWeather; // Update the weather instance
                        days = weather.getDayList();
                        mutableLiveDataDays.setValue(days); // Update the LiveData with the new days list
                    }
                }
            });
        }

//        Log.e("Days","Weather is Null 2 "+ (weather == null));
//
//        if(weather != null && weather.getDayList() != null){
//            days = weather.getDayList();
//            mutableLiveDataDays.setValue(days);
//        }
        return mutableLiveDataDays;
    }
}
