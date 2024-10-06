package com.example.weatherapplication.api;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    private static String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/";


    public static weatherServiceApi getService(){



        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        };

        Log.e("getService", "getService");

        return retrofit.create(weatherServiceApi.class);

    }

}
