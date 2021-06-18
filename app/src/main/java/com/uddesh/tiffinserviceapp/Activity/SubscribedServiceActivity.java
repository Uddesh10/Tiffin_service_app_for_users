package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.R;

public class SubscribedServiceActivity extends AppCompatActivity {
    private PorterShapeImageView subscribedServiceTabImageView;
    private ImageView  subscribedServiceLogoImageView;
    private TextView subscribedServiceDaysTextView, subscribedServiceProviderNameTextView, subscribedServiceNameTextView, subscribedServiceDescriptionTextView;
    private Button subscribedServicePauseButton, subscribedServiceRenewButton ,subscribedServiceResumeButton;
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
        subscribedServiceTabImageView = findViewById(R.id.subscribedServiceTabImageView);
        subscribedServiceLogoImageView = findViewById(R.id.subscribedServiceLogoImageView);
        subscribedServiceDaysTextView = findViewById(R.id.subscribedServiceDaysTextView);
        subscribedServiceProviderNameTextView = findViewById(R.id.subscribedServiceProviderNameTextView);
        subscribedServiceNameTextView = findViewById(R.id.subscribedServiceNameTextView);
        subscribedServiceDescriptionTextView = findViewById(R.id.subscribedServiceDescriptionTextView);
        subscribedServicePauseButton = findViewById(R.id.subscribedServicePauseButton);
        subscribedServiceRenewButton = findViewById(R.id.subscribedServiceRenewButton);
        subscribedServiceResumeButton = findViewById(R.id.subscribedServiceResumeButton);
    }

    private void clickListeners()
    {
        subscribedServicePauseButton.setOnClickListener(v -> {

        });
        subscribedServiceRenewButton.setOnClickListener(v -> {

        });
        subscribedServiceResumeButton.setOnClickListener(v -> {

        });
    }
}