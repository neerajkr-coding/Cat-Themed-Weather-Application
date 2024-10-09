package com.example.weatherapplication.models;


import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.weatherapplication.R;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

        @SerializedName("tempmax")
        private Double maxTemp;

        @SerializedName("tempmin")
        private Double minTemp;

        @SerializedName("conditions")
        private String Condition;


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

        public Double getMaxTemp() {
                return FtoC(minTemp);
        }

        public void setMaxTemp(Double maxTemp) {
                this.maxTemp = maxTemp;
        }

        public Double getMinTemp() {

                return FtoC(minTemp);
        }

        public void setMinTemp(Double minTemp) {
                this.minTemp = minTemp;
        }

        public String getCondition() {

//                "Clear"
//                "Rain" == "Rain"
//                "Overcast" == "Clear"
//                "Rain, Partially cloudy" == "Rain"
//                "Partially cloudy" == "Cloudy"
//                "Rain, Overcast" == "Cloudy"


                String res = "";

                if(Condition.contains("Overcast")){
                        Condition = "Overcast";

                }else if(Condition.contains("Partially cloudy")){
                        Condition = "Cloudy";
                }


                return Condition;
        }

        public void setCondition(String condition) {
                Condition = condition;
        }

        private double FtoC(double f){
                double res = (f - 32.0) * (5.0 / 9.0);
                return Math.round(res * 10.0) / 10.0;
        }

        public String getCurrDay(){
                String date = getDate();

                String day = getWeekday(date).substring(0,3);


                return day;

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

        @BindingAdapter("setImg")
        public static void setIcon(ImageView imageView, Day day){
                int img;
                String condition = day.getCondition();

                Log.v("Day", day.date +"-"+day.getCondition());

                if(condition.equals("Clear")){
                        img = R.drawable.sun_outline;
                }else if(condition.equals("Overcast")){
                        img = R.drawable.overcast_outline;
                }else if(condition.equals("Rain")){
                        img = R.drawable.rain_outline;
                }else{
                        img = R.drawable.cloudy_outline;
                }

                if(day.getTemp()<17.0){
                        img = img = R.drawable.cold_outline2;
                }

                imageView.setImageResource(img);
        }


}
