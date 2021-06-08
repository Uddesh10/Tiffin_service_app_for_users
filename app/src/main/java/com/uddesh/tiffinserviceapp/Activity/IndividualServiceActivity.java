package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.R;

public class IndividualServiceActivity extends AppCompatActivity {

    PorterShapeImageView tab_imageview;
    TextView service_provider_name_textview ,service_name_textview, price_textview;
    Button subscribe_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_service);
        initialiseComponents();
        clickListeners();

    }

    // Private functions
    private void initialiseComponents()
    {
        tab_imageview = findViewById(R.id.tab_imageView);
        service_provider_name_textview = findViewById(R.id.service_provider_name_textview);
        service_name_textview = findViewById(R.id.service_name_textview);
        price_textview= findViewById(R.id.price_textview);
        subscribe_button = findViewById(R.id.subscribe_button);
    }

    private void clickListeners()
    {
        subscribe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}