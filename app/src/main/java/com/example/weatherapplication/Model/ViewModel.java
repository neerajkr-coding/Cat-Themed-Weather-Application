package com.example.weatherapplication.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

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

        Call<Weather> call = serviceApi
                .getWeatherData(city, application.getApplicationContext().getString(R.string.apiKey));

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                Weather w = response.body();

                if(w != null && w.getDayList() != null){
                    weather = w;
                    mutableLiveDataWeather.setValue(weather);
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable throwable) {

            }
        });

        return mutableLiveDataWeather;
    }

    public MutableLiveData<List<Day>> getMutableLiveDataDays(){

        if(weather != null && weather.getDayList() != null){
            days = weather.getDayList();
            mutableLiveDataDays.setValue(days);
        }
        return mutableLiveDataDays;
    }
}
