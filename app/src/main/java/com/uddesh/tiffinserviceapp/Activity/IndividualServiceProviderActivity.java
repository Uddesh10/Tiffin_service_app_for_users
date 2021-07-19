package com.uddesh.tiffinserviceapp.Activity;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.Adapters.IndividualServiceRecyclerAdapter;
import com.uddesh.tiffinserviceapp.DataModels.GetServiceProviderModel;
import com.uddesh.tiffinserviceapp.R;
import com.uddesh.tiffinserviceapp.Repository.PicassoRepository;
import com.uddesh.tiffinserviceapp.Repository.RetrofitViewModel;

public class IndividualServiceProviderActivity extends AppCompatActivity {
    private PorterShapeImageView individualServiceProviderTabImageView;
    private ImageView individualServiceProviderLogoImageView;
    private IndividualServiceRecyclerAdapter individualServiceRecyclerAdapterInstance;
    private TextView individualServiceProviderDistanceTextView , individualServiceProviderVegTextView , individualServiceProviderNameTextView,individualServiceProviderLunchDinnerTextView ,individualServiceProviderDeliveryTimingsTextView ,individualServiceProviderPhoneTextView,individualServiceProviderNonVegTextView;
    private PicassoRepository picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_service_provider);
        initializeComponent();
    }


    // private functions
    private void initializeComponent()
    {
        RetrofitViewModel viewModel = new RetrofitViewModel(getApplication());
        String providerName = getIntent().getStringExtra("providerName");
        picasso = new PicassoRepository();
        individualServiceProviderTabImageView = findViewById(R.id.individualServiceProviderTabImageView);
        individualServiceProviderLogoImageView = findViewById(R.id.individualServiceProviderLogoImageView);
        individualServiceProviderDistanceTextView = findViewById(R.id.individualServiceProviderDistanceTextView);
        individualServiceProviderLunchDinnerTextView = findViewById(R.id.individualServiceProviderLunchDinnerTextView);
        individualServiceProviderDeliveryTimingsTextView = findViewById(R.id.individualServiceProviderDeliveryTimingsTextView);
        individualServiceProviderPhoneTextView = findViewById(R.id.individualServiceProviderPhoneTextView);
        individualServiceProviderNonVegTextView = findViewById(R.id.individualServiceProviderNonVegTextView);
        individualServiceProviderVegTextView = findViewById(R.id.individualServiceProviderVegTextView);
        individualServiceProviderNameTextView = findViewById(R.id.individualServiceProviderNameTextView);
        RecyclerView individualServiceProviderRecyclerView = findViewById(R.id.individualServiceProviderRecyclerView);
        individualServiceProviderRecyclerView.setLayoutManager(new LinearLayoutManager( this ,LinearLayoutManager.HORIZONTAL , false));
        individualServiceRecyclerAdapterInstance = new IndividualServiceRecyclerAdapter(this);
        individualServiceProviderRecyclerView.setAdapter(individualServiceRecyclerAdapterInstance);
        viewModel.getServiceProvider(providerName).observe(this , result->{
            if(result!=null)
            {
                updateUi(result);
            }
        });
    }

    private void updateUi(GetServiceProviderModel result) {
        String logoImage = result.getLogoimage();
        String foodImage = result.getServices().get(0).getFoodimage();
        String distance = result.getDistance()+" Km";
        String contact = "Contact No. :"+result.getContactno();
        String timings = result.getLunchtimings()+"\n"+result.getDinnertimings();
        picasso.getFoodImage(foodImage , individualServiceProviderTabImageView);
        picasso.getLogoImage(logoImage , individualServiceProviderLogoImageView);
        individualServiceProviderDistanceTextView.setText(distance);
        individualServiceProviderNameTextView.setText(result.getProvidername());
        individualServiceProviderLunchDinnerTextView.setText(result.getAvailability());
        individualServiceProviderPhoneTextView.setText(contact);
        individualServiceProviderDeliveryTimingsTextView.setText(timings);
        individualServiceProviderVegTextView.setVisibility(View.VISIBLE);
        if(result.isVegnonveg())
        {
            individualServiceProviderNonVegTextView.setVisibility(View.VISIBLE);
        }
        else {
            individualServiceProviderNonVegTextView.setVisibility(View.GONE);
        }
        individualServiceRecyclerAdapterInstance.notifyDataSetChanged(result.getServices());

    }


}