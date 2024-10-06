package com.example.weatherapplication.api;

import com.example.weatherapplication.Model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface weatherServiceApi {

    @GET("timeline/{city}")
    Call<Weather> getWeatherData(@Path("city") String cityName,@Query("key") String apiKey);

//    @GET("timeline/Kolkata")
//    Call<Weather> getWeatherData(@Query("key") String apiKey);
}
