package com.example.weatherapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapplication.databinding.ActivityMainBinding;
import com.example.weatherapplication.models.*;

public class MainActivity extends AppCompatActivity {



    TextView tv;

    Button b;
    EditText et;

    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        b = activityMainBinding.btn;
        et = activityMainBinding.editText;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et.getText().toString();

                Intent i = new Intent(getApplicationContext(), WeatherActivity.class);
                i.putExtra("Loc",str);
                startActivity(i);
            }
        });


    }
}