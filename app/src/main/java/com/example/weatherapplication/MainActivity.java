package com.example.weatherapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapplication.Model.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewModel viewModel;

    TextView tv;

    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        tv = findViewById(R.id.tv);
        b = findViewById(R.id.btn);

        tv.setText("test");



        viewModel.getMutableLiveDataWeather("Janakpuri").observe(this, new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {
                tv.setText(weather.getTimeZone());
            }
        });

    }
}