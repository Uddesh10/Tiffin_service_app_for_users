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
    private ImageView service_provider_logo_imageview;
    private TextView service_provider_name_textview,veg_textview , nonveg_textview ,distance_textview , availability_textview , price_textview;
    public ServiceListFragmentRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        service_provider_logo_imageview = itemView.findViewById(R.id.service_provider_logo_imageview);
        service_provider_name_textview = itemView.findViewById(R.id.service_provider_name_textview);
        veg_textview = itemView.findViewById(R.id.veg_textview);
        nonveg_textview = itemView.findViewById(R.id.nonveg_textview);
        distance_textview = itemView.findViewById(R.id.distance_textview);
        availability_textview = itemView.findViewById(R.id.availability_textview);
        price_textview = itemView.findViewById(R.id.price_textview);
    }

    public ImageView getService_provider_logo_imageview() {
        return service_provider_logo_imageview;
    }

    public TextView getService_provider_name_textview() {
        return service_provider_name_textview;
    }

    public TextView getVeg_textview() {
        return veg_textview;
    }

    public TextView getNonveg_textview() {
        return nonveg_textview;
    }

    public TextView getDistance_textview() {
        return distance_textview;
    }

    public TextView getAvailability_textview() {
        return availability_textview;
    }

    public TextView getPrice_textview() {
        return price_textview;
    }
}
