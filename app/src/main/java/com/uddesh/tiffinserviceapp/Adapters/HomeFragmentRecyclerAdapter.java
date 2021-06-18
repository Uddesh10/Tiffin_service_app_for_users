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
        View view = inflater.inflate(R.layout.individual_subscribed_card , parent , false);
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
    private ImageView subscribedCardLogoImageView;
    private TextView subscribedCardNameTextView , subscribedCardServiceNameTextView , subscribedCardActiveTextView , subscribedCardNotActiveTextView;
    public HomeFragmentRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        subscribedCardLogoImageView = itemView.findViewById(R.id.subscribedCardLogoImageView);
        subscribedCardNameTextView = itemView.findViewById(R.id.subscribedCardNameTextView);
        subscribedCardActiveTextView = itemView.findViewById(R.id.subscribedCardActiveTextView);
        subscribedCardNotActiveTextView = itemView.findViewById(R.id.subscribedCardNotActiveTextView);
        subscribedCardServiceNameTextView = itemView.findViewById(R.id.subscribedCardServiceNameTextView);
    }

    public ImageView getSubscribedCardLogoImageView() {
        return subscribedCardLogoImageView;
    }

    public TextView getSubscribedCardNameTextView() {
        return subscribedCardNameTextView;
    }

    public TextView getSubscribedCardServiceNameTextView() {
        return subscribedCardServiceNameTextView;
    }

    public TextView getSubscribedCardActiveTextView() {
        return subscribedCardActiveTextView;
    }

    public TextView getSubscribedCardNotActiveTextView() {
        return subscribedCardNotActiveTextView;
    }
}
