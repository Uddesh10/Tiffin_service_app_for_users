package com.uddesh.tiffinserviceapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.DataModels.GetServiceModel;
import com.uddesh.tiffinserviceapp.R;
import com.uddesh.tiffinserviceapp.Repository.PicassoRepository;
import com.uddesh.tiffinserviceapp.Repository.RetrofitViewModel;

public class IndividualServiceActivity extends AppCompatActivity {

    private PorterShapeImageView individualServiceTabImageView;
    private TextView individualServiceNameTextView,individualServiceDescriptionTextview,individualServicePriceTextview;
    private Button individualServiceSubscribeButton;
    private PicassoRepository picasso;

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
        RetrofitViewModel viewModel = new RetrofitViewModel(getApplication());
        individualServiceTabImageView = findViewById(R.id.individualServiceTabImageView);
        individualServiceNameTextView = findViewById(R.id.individualServiceNameTextView);
        individualServiceDescriptionTextview = findViewById(R.id.individualServiceDescriptionTextview);
        individualServicePriceTextview = findViewById(R.id.individualServicePriceTextview);
        individualServiceSubscribeButton = findViewById(R.id.individualServiceSubscribeButton);
        picasso = new PicassoRepository();
        viewModel.getService(getIntent().getIntExtra("id" , 0)).observe(this , result->{
            if(result!=null)
            {
                updateUI(result);
            }
        });

    }

    private void updateUI(GetServiceModel result) {
        String fileName = result.getFoodimage();
        String price = "Price: "+result.getPrice()+"₹/ 30 days";
        picasso.getFoodImage(fileName , individualServiceTabImageView);
        individualServiceNameTextView.setText(result.getServicename());
        individualServiceDescriptionTextview.setText(result.getDescription());
        individualServicePriceTextview.setText(price);

    }

    private void clickListeners()
    {
        individualServiceSubscribeButton.setOnClickListener(v -> {

        });

    }
}