package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.Adapters.ServiceListFragmentRecyclerAdapter;
import com.uddesh.tiffinserviceapp.R;

public class IndividualServiceProviderActivity extends AppCompatActivity {
    private PorterShapeImageView tab_imageView;
    private RecyclerView individual_service_recyclerview;
    private ImageView service_logo_imageview;
    private  ServiceListFragmentRecyclerAdapter serviceListFragmentRecyclerAdapterInstance;
    private TextView service_provider_name_textview , veg_textview , nonveg_textvview,distance_textview ,lunch_dinner_textview ,delivery_timings_textview,phone_no_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_service_provider);
        initialiseComponent();
    }


    // private functions
    private void initialiseComponent()
    {
        tab_imageView = findViewById(R.id.tab_imageView);
        service_logo_imageview = findViewById(R.id.service_logo_imageview);
        service_provider_name_textview = findViewById(R.id.service_provider_name_textview);
        distance_textview = findViewById(R.id.distance_textview);
        lunch_dinner_textview = findViewById(R.id.lunch_dinner_textview);
        delivery_timings_textview = findViewById(R.id.delivery_timings_textview);
        phone_no_textview = findViewById(R.id.phone_no_textview);
        veg_textview = findViewById(R.id.veg_textview);
        nonveg_textvview = findViewById(R.id.nonveg_textview);
        individual_service_recyclerview = findViewById(R.id.individual_service_recyclerview);
        individual_service_recyclerview.setLayoutManager(new LinearLayoutManager( this ,LinearLayoutManager.HORIZONTAL , false));
        serviceListFragmentRecyclerAdapterInstance = new ServiceListFragmentRecyclerAdapter();
        individual_service_recyclerview.setAdapter(serviceListFragmentRecyclerAdapterInstance);
    }



    // public functions

}