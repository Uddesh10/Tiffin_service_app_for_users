package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uddesh.tiffinserviceapp.R;

public class IndividualServiceActivity extends AppCompatActivity {

    ImageView tab_imageview;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_service);

        tab_imageview = findViewById(R.id.tab_imageView);
        textView = findViewById(R.id.service_provider_name_textview);
        textView = findViewById(R.id.service_name_textview);
        textView = findViewById(R.id.price_textview);
        button = findViewById(R.id.subscribe_button);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}