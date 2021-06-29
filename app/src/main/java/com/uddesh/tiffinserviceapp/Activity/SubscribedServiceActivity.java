package com.uddesh.tiffinserviceapp.Activity;


import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.uddesh.tiffinserviceapp.DataModels.SubscribedServiceDetailsModel;
import com.uddesh.tiffinserviceapp.Helpers.ToastHelper;
import com.uddesh.tiffinserviceapp.R;
import com.uddesh.tiffinserviceapp.Repository.PicassoRepository;
import com.uddesh.tiffinserviceapp.Repository.RetrofitViewModel;

public class SubscribedServiceActivity extends AppCompatActivity {
    private PorterShapeImageView subscribedServiceTabImageView;
    private ImageView  subscribedServiceLogoImageView;
    private TextView subscribedServiceDaysTextView, subscribedServiceProviderNameTextView, subscribedServiceNameTextView, subscribedServiceDescriptionTextView;
    private Button subscribedServicePauseButton, subscribedServiceRenewButton ,subscribedServiceResumeButton;
    private int id;
    private RetrofitViewModel viewModel;
    private ToastHelper toast;
    private PicassoRepository picasso;
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
        id = getIntent().getIntExtra("id" , 0);
        viewModel = new RetrofitViewModel(getApplication());
        toast = new ToastHelper(this);
        picasso = new PicassoRepository();
        subscribedServiceTabImageView = findViewById(R.id.subscribedServiceTabImageView);
        subscribedServiceLogoImageView = findViewById(R.id.subscribedServiceLogoImageView);
        subscribedServiceDaysTextView = findViewById(R.id.subscribedServiceDaysTextView);
        subscribedServiceProviderNameTextView = findViewById(R.id.subscribedServiceProviderNameTextView);
        subscribedServiceNameTextView = findViewById(R.id.subscribedServiceNameTextView);
        subscribedServiceDescriptionTextView = findViewById(R.id.subscribedServiceDescriptionTextView);
        subscribedServicePauseButton = findViewById(R.id.subscribedServicePauseButton);
        subscribedServiceRenewButton = findViewById(R.id.subscribedServiceRenewButton);
        subscribedServiceResumeButton = findViewById(R.id.subscribedServiceResumeButton);
        viewModel.getSubscribedServiceDetails(id).observe(this , result->{
            if(result!=null)
            {
                updateUI(result);
            }
        });

    }

    private void updateUI(SubscribedServiceDetailsModel result) {
        String logoImage = result.getLogoimage();
        String foodImage = result.getFoodimage();
        String days = result.getDaysremaining()+"";
        picasso.getLogoImage(logoImage , subscribedServiceLogoImageView);
        picasso.getFoodImage(foodImage , subscribedServiceTabImageView);
        subscribedServiceProviderNameTextView.setText(result.getProvidername());
        subscribedServiceNameTextView.setText(result.getServicename());
        subscribedServiceDescriptionTextView.setText(result.getServicedescription());
        subscribedServiceDaysTextView.setText(days);
        if(result.getActive())
        {
            subscribedServicePauseButton.setVisibility(View.VISIBLE);
            subscribedServiceResumeButton.setVisibility(View.GONE);
        }
        else{
            subscribedServicePauseButton.setVisibility(View.GONE);
            subscribedServiceResumeButton.setVisibility(View.VISIBLE);
        }
    }

    private void clickListeners()
    {
        subscribedServicePauseButton.setOnClickListener(v -> viewModel.updateActive(id , false).observe(this , result->{
            if(result)
            {
                toast.makeToast("Service paused" , Toast.LENGTH_LONG);
                finish();
            }
            else{
                toast.makeToast("Something went wrong" , Toast.LENGTH_LONG);
            }
        }));
        subscribedServiceRenewButton.setOnClickListener(v -> {
        });
        subscribedServiceResumeButton.setOnClickListener(v -> viewModel.updateActive(id , true).observe(this , result->{
            if(result)
            {
                toast.makeToast("Service resumed" , Toast.LENGTH_LONG);
                finish();
            }
            else{
                toast.makeToast("Something went wrong" , Toast.LENGTH_LONG);
            }
        }));
    }
}