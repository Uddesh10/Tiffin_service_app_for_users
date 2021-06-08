package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uddesh.tiffinserviceapp.R;

public class IndividualServiceProviderActivity extends AppCompatActivity {
    ImageView tab_imageView ,service_logo_imageview;
    TextView service_provider_name_textview ,service_name_textview ,lunch_dinner_textview ,delivery_timings_textview ,textView10 ,phone_no_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_service_provider);

        tab_imageView = findViewById(R.id.tab_imageView);
        service_logo_imageview = findViewById(R.id.service_logo_imageview);
        service_provider_name_textview = findViewById(R.id.service_provider_name_textview);
        service_name_textview = findViewById(R.id.service_name_textview);
        lunch_dinner_textview = findViewById(R.id.lunch_dinner_textview);
        delivery_timings_textview = findViewById(R.id.delivery_timings_textview);
        textView10 = findViewById(R.id.textView10);
        phone_no_textview = findViewById(R.id.phone_no_textview);
    }


}