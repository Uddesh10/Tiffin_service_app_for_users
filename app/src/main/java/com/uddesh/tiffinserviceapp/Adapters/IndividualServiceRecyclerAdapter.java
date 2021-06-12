package com.uddesh.tiffinserviceapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.uddesh.tiffinserviceapp.R;

public class IndividualServiceRecyclerAdapter extends RecyclerView.Adapter<IndividualServiceRecyclerViewHolder> {
    @NonNull
    @Override
    public IndividualServiceRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.individual_service_card , parent , false);
        return new IndividualServiceRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IndividualServiceRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class IndividualServiceRecyclerViewHolder extends RecyclerView.ViewHolder
{
    private ImageView service_imageview;
    private TextView service_name_textview , price_textview;
    public IndividualServiceRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        service_imageview = itemView.findViewById(R.id.service_imageview);
        service_name_textview = itemView.findViewById(R.id.service_name_textview);
        price_textview = itemView.findViewById(R.id.price_textview);
    }

    public ImageView getService_imageview() {
        return service_imageview;
    }

    public TextView getService_name_textview() {
        return service_name_textview;
    }

    public TextView getPrice_textview() {
        return price_textview;
    }
}