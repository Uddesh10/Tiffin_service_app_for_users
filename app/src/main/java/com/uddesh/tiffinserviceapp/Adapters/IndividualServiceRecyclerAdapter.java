package com.uddesh.tiffinserviceapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.uddesh.tiffinserviceapp.Activity.IndividualServiceActivity;
import com.uddesh.tiffinserviceapp.DataModels.ServiceModel;
import com.uddesh.tiffinserviceapp.R;
import com.uddesh.tiffinserviceapp.Repository.PicassoRepository;

import java.util.List;

public class IndividualServiceRecyclerAdapter extends RecyclerView.Adapter<IndividualServiceRecyclerViewHolder> {
    private List<ServiceModel> model;
    private final Context mContext;
    private final PicassoRepository picasso = new PicassoRepository();
    public IndividualServiceRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public IndividualServiceRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.individual_service_card , parent , false);
        return new IndividualServiceRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IndividualServiceRecyclerViewHolder holder, int position) {
        if(model!=null)
        {
            String fileName = model.get(position).getFoodimage();
            String price = "Price:- "+model.get(position).getPrice()+"₹/30 days";
            picasso.getFoodImage(fileName , holder.getIndividualServiceCardImageView());
            holder.getIndividualServiceCardNameTextView().setText(model.get(position).getServicename());
            holder.getIndividualServiceCardPriceTextView().setText(price);
            holder.itemView.setOnClickListener(v->{
                Intent intent = new Intent(mContext , IndividualServiceActivity.class);
                intent.putExtra("id" , model.get(position).getId());
                mContext.startActivity(intent);
            });

        }
    }

    @Override
    public int getItemCount() {
        if(model!=null)
            return model.size();
        else
            return 0;
    }

    public void notifyDataSetChanged(List<ServiceModel> model)
    {
        this.model = model;
        notifyDataSetChanged();
    }
}

class IndividualServiceRecyclerViewHolder extends RecyclerView.ViewHolder
{
    private final ImageView individualServiceCardImageView;
    private final TextView individualServiceCardNameTextView , individualServiceCardPriceTextView;
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