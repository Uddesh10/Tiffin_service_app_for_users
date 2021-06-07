package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uddesh.tiffinserviceapp.R;

public class SubscribedServiceActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribed_service);
        imageView = findViewById(R.id.tab_imageView);
        imageView= findViewById(R.id.service_logo_imageview);
        textView = findViewById(R.id.days_remaining_textview);
        textView = findViewById(R.id.textView16);
        textView = findViewById(R.id.service_provider_name_textview);
        textView = findViewById(R.id.service_name_textview);
        textView = findViewById(R.id.service_desciption_textview);
        button = findViewById(R.id.pause_service_button);
        button = findViewById(R.id.resume_service_button);
        button = findViewById(R.id.renew_button);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}