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
    private ImageView individualServiceCardImageView;
    private TextView individualServiceCardNameTextView , individualServiceCardPriceTextView;
    public IndividualServiceRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        individualServiceCardImageView = itemView.findViewById(R.id.individualServiceCardImageView);
        individualServiceCardNameTextView = itemView.findViewById(R.id.individualServiceCardNameTextView);
        individualServiceCardPriceTextView = itemView.findViewById(R.id.individualServiceCardPriceTextView);
    }

    public ImageView getIndividualServiceCardImageView() {
        return individualServiceCardImageView;
    }

    public TextView getIndividualServiceCardNameTextView() {
        return individualServiceCardNameTextView;
    }

    public TextView getIndividualServiceCardPriceTextView() {
        return individualServiceCardPriceTextView;
    }
}