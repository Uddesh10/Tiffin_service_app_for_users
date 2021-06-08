package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.R;

public class SubscribedServiceActivity extends AppCompatActivity {
    PorterShapeImageView tab_imageView;
    ImageView  service_logo_imageView;
    TextView days_remaining_textView, service_provider_name_textView, service_name_textView, service_desciption_textView;
    Button pause_service_button, resume_service_button ,renew_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribed_service);
        initialiseComponents();
        clickListeners();

    }

    //Private functions
    private void initialiseComponents()
    {
        tab_imageView = findViewById(R.id.tab_imageView);
        service_logo_imageView= findViewById(R.id.service_logo_imageview);
        days_remaining_textView = findViewById(R.id.days_remaining_textview);
        service_provider_name_textView = findViewById(R.id.service_provider_name_textview);
        service_name_textView = findViewById(R.id.service_name_textview);
        service_desciption_textView = findViewById(R.id.service_desciption_textview);
        pause_service_button = findViewById(R.id.pause_service_button);
        resume_service_button = findViewById(R.id.resume_service_button);
        renew_button = findViewById(R.id.renew_button);
    }

    private void clickListeners()
    {
        pause_service_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        resume_service_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        renew_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}