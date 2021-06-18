package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.Adapters.IndividualServiceRecyclerAdapter;
import com.uddesh.tiffinserviceapp.R;

public class IndividualServiceProviderActivity extends AppCompatActivity {
    private PorterShapeImageView individualServiceProviderTabImageView;
    private RecyclerView individualServiceProviderRecyclerView;
    private ImageView individualServiceProviderLogoImageView;
    private IndividualServiceRecyclerAdapter individualServiceRecyclerAdapterInstance;
    private TextView individualServiceProviderDistanceTextView , individualServiceProviderVegTextView , individualServiceProviderNameTextView,individualServiceProviderLunchDinnerTextView ,individualServiceProviderDeliveryTimingsTextView ,individualServiceProviderPhoneTextView,individualServiceProviderNonVegTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_service_provider);
        initialiseComponent();
    }


    // private functions
    private void initialiseComponent()
    {
        individualServiceProviderTabImageView = findViewById(R.id.individualServiceProviderTabImageView);
        individualServiceProviderLogoImageView = findViewById(R.id.individualServiceProviderLogoImageView);
        individualServiceProviderDistanceTextView = findViewById(R.id.individualServiceProviderDistanceTextView);
        individualServiceProviderLunchDinnerTextView = findViewById(R.id.individualServiceProviderLunchDinnerTextView);
        individualServiceProviderDeliveryTimingsTextView = findViewById(R.id.individualServiceProviderDeliveryTimingsTextView);
        individualServiceProviderPhoneTextView = findViewById(R.id.individualServiceProviderPhoneTextView);
        individualServiceProviderNonVegTextView = findViewById(R.id.individualServiceProviderNonVegTextView);
        individualServiceProviderVegTextView = findViewById(R.id.individualServiceProviderVegTextView);
        individualServiceProviderNameTextView = findViewById(R.id.individualServiceProviderNameTextView);
        individualServiceProviderRecyclerView = findViewById(R.id.individualServiceProviderRecyclerView);
        individualServiceProviderRecyclerView.setLayoutManager(new LinearLayoutManager( this ,LinearLayoutManager.HORIZONTAL , false));
        individualServiceRecyclerAdapterInstance = new IndividualServiceRecyclerAdapter();
        individualServiceProviderRecyclerView.setAdapter(individualServiceRecyclerAdapterInstance);
    }



    // public functions

}