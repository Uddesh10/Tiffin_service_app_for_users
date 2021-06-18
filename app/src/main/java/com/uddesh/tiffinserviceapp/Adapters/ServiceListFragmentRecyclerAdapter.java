package com.uddesh.tiffinserviceapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uddesh.tiffinserviceapp.R;

public class ServiceListFragmentRecyclerAdapter extends RecyclerView.Adapter<ServiceListFragmentRecyclerViewHolder>  {
    @NonNull
    @Override
    public ServiceListFragmentRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.individual_service_provider_card , parent , false);
        return new ServiceListFragmentRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceListFragmentRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class ServiceListFragmentRecyclerViewHolder extends RecyclerView.ViewHolder
{
    private ImageView serviceProviderCardLogoImageview;
    private TextView serviceProviderCardNameTextView,serviceProviderCardVegTextView , serviceProviderCardNonVegTextView ,serviceProviderCardDistanceTextView , serviceProviderCardAvailabilityTextView , serviceProviderCardPriceTextView;
    public ServiceListFragmentRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        serviceProviderCardLogoImageview = itemView.findViewById(R.id.serviceProviderCardLogoImageview);
        serviceProviderCardNameTextView = itemView.findViewById(R.id.serviceProviderCardNameTextView);
        serviceProviderCardVegTextView = itemView.findViewById(R.id.serviceProviderCardVegTextView);
        serviceProviderCardNonVegTextView = itemView.findViewById(R.id.serviceProviderCardNonVegTextView);
        serviceProviderCardDistanceTextView = itemView.findViewById(R.id.serviceProviderCardDistanceTextView);
        serviceProviderCardAvailabilityTextView = itemView.findViewById(R.id.serviceProviderCardAvailabilityTextView);
        serviceProviderCardPriceTextView = itemView.findViewById(R.id.serviceProviderCardPriceTextView);
    }

    public ImageView getServiceProviderCardLogoImageview() {
        return serviceProviderCardLogoImageview;
    }

    public TextView getServiceProviderCardNameTextView() {
        return serviceProviderCardNameTextView;
    }

    public TextView getServiceProviderCardVegTextView() {
        return serviceProviderCardVegTextView;
    }

    public TextView getServiceProviderCardNonVegTextView() {
        return serviceProviderCardNonVegTextView;
    }

    public TextView getServiceProviderCardDistanceTextView() {
        return serviceProviderCardDistanceTextView;
    }

    public TextView getServiceProviderCardAvailabilityTextView() {
        return serviceProviderCardAvailabilityTextView;
    }

    public TextView getServiceProviderCardPriceTextView() {
        return serviceProviderCardPriceTextView;
    }
}
