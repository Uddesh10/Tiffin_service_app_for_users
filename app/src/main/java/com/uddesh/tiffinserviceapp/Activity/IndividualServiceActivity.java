package com.uddesh.tiffinserviceapp.Activity;

import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.DataModels.AddSubscriptionModel;
import com.uddesh.tiffinserviceapp.DataModels.GetServiceModel;
import com.uddesh.tiffinserviceapp.Helpers.SharedPreferencesHelper;
import com.uddesh.tiffinserviceapp.Helpers.ToastHelper;
import com.uddesh.tiffinserviceapp.R;
import com.uddesh.tiffinserviceapp.Repository.PicassoRepository;
import com.uddesh.tiffinserviceapp.Repository.RetrofitViewModel;

public class IndividualServiceActivity extends AppCompatActivity {

    private PorterShapeImageView individualServiceTabImageView;
    private TextView individualServiceNameTextView,individualServiceDescriptionTextview,individualServicePriceTextview;
    private Button individualServiceSubscribeButton;
    private PicassoRepository picasso;
    private RetrofitViewModel viewModel;
    private SharedPreferencesHelper sharedPreferences;
    private ToastHelper toast;

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
        toast = new ToastHelper(this);
        sharedPreferences = new SharedPreferencesHelper(this);
        viewModel = new RetrofitViewModel(getApplication());
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
            String username = sharedPreferences.getSharedPreferences("username");
            int id = getIntent().getIntExtra("id" , 0);
            viewModel.addSubscription(new AddSubscriptionModel(username , id , 30 , true)).observe(this , result->{
                if(result)
                {
                    toast.makeToast("Subscribed successfully" , Toast.LENGTH_LONG);
                    Intent intent = new Intent(this , HomePageActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else {
                    toast.makeToast("Something went wrong" , Toast.LENGTH_LONG);
                }
            });
        });

    }
}