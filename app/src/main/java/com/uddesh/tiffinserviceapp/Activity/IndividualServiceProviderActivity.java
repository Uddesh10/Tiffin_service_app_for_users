package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uddesh.tiffinserviceapp.R;

public class IndividualServiceProviderActivity extends AppCompatActivity {
    ImageView image;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_service_provider);
        image = findViewById(R.id.tab_imageView);
        image = findViewById(R.id.service_logo_imageview);
        textview = findViewById(R.id.service_provider_name_textview);
        textview = findViewById(R.id.service_name_textview);
        textview = findViewById(R.id.lunch_dinner_textview);
        textview = findViewById(R.id.delivery_timings_textview);
        textview = findViewById(R.id.textView10);
        textview = findViewById(R.id.phone_no_textview);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }