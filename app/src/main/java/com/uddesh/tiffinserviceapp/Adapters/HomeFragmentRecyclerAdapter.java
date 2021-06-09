package com.uddesh.tiffinserviceapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.uddesh.tiffinserviceapp.R;


public class HomeFragmentRecyclerAdapter extends RecyclerView.Adapter<HomeFragmentRecyclerViewHolder>  {
    @NonNull
    @Override
    public HomeFragmentRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.individual_service_provider_card , parent , false);
        return new HomeFragmentRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class HomeFragmentRecyclerViewHolder extends RecyclerView.ViewHolder
{
    ImageView service_logo_imageview;
    TextView service_provider_name_textview , service_name_textview , service_active_textview , service_notactive_textview;
    public HomeFragmentRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        service_logo_imageview = itemView.findViewById(R.id.service_logo_imageview);
        service_provider_name_textview = itemView.findViewById(R.id.service_provider_name_textview);
        service_active_textview = itemView.findViewById(R.id.service_active_textview);
        service_notactive_textview = itemView.findViewById(R.id.service_not_active_textview);
        service_name_textview = itemView.findViewById(R.id.service_name_textview);
    }

    public ImageView getService_logo_imageview() {
        return service_logo_imageview;
    }

    public TextView getService_provider_name_textview() {
        return service_provider_name_textview;
    }

    public TextView getService_name_textview() {
        return service_name_textview;
    }

    public TextView getService_active_textview() {
        return service_active_textview;
    }

    public TextView getService_notactive_textview() {
        return service_notactive_textview;
    }
}
