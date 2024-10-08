package com.example.weatherapplication.models;


import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class Day {

        @SerializedName("datetime")
        private String date;

        @SerializedName("temp")
        private Double temp;

        @SerializedName("feelslike")
        private Double feelslike;

        @SerializedName("humidity")
        private Double humidity;

        @SerializedName("precipprob")
        private Double precipprob;

        public Double getTemp() {
                return FtoC(temp);
        }

        public void setTemp(Double temp) {
                this.temp = temp;
        }

        public Double getFeelslike() {
                return feelslike;
        }

        public void setFeelslike(Double feelslike) {
                this.feelslike = feelslike;
        }

        public Double getHumidity() {
                return humidity;
        }

        public void setHumidity(Double humidity) {
                this.humidity = humidity;
        }

        public Double getPrecipprob() {
                return precipprob;
        }

        public void setPrecipprob(Double precipprob) {
                this.precipprob = precipprob;
        }

        public String getDate() {
//                2024-10-08

                String modifiedDate = date.replace("-", "/");
                return modifiedDate;
        }

        public void setDate(String date) {
                this.date = date;
        }

        private double FtoC(double f){
                double res = (f - 32.0) * (5.0 / 9.0);
                return Math.round(res * 10.0) / 10.0;
        }
}
