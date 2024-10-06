package com.example.weatherapplication.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day {

        @SerializedName("temp")
        @Expose
        private Double temp;

        @SerializedName("feelslike")
        @Expose
        private Double feelslike;

        @SerializedName("humidity")
        @Expose
        private Double humidity;

        @SerializedName("precipprob")
        @Expose
        private Double precipprob;

        public Double getTemp() {
                return temp;
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
}
