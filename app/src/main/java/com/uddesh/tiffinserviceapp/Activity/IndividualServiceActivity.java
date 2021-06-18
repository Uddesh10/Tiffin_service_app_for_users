package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.R;

public class IndividualServiceActivity extends AppCompatActivity {

    PorterShapeImageView individualServiceTabImageView;
    TextView individualServiceNameTextView,individualServiceDescriptionTextview,individualServicePriceTextview;
    Button individualServiceSubscribeButton;
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
        individualServiceTabImageView = findViewById(R.id.individualServiceTabImageView);
        individualServiceNameTextView = findViewById(R.id.individualServiceNameTextView);
        individualServiceDescriptionTextview = findViewById(R.id.individualServiceDescriptionTextview);
        individualServicePriceTextview = findViewById(R.id.individualServicePriceTextview);
        individualServiceSubscribeButton = findViewById(R.id.individualServiceSubscribeButton);
    }

    private void clickListeners()
    {
        individualServiceSubscribeButton.setOnClickListener(v -> {

        });

    }
}