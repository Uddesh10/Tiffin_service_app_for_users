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
import com.uddesh.tiffinserviceapp.Activity.SubscribedServiceActivity;
import com.uddesh.tiffinserviceapp.DataModels.SubscribedServiceModel;
import com.uddesh.tiffinserviceapp.R;
import com.uddesh.tiffinserviceapp.Repository.PicassoRepository;
import java.util.List;


public class HomeFragmentRecyclerAdapter extends RecyclerView.Adapter<HomeFragmentRecyclerViewHolder>  {
    private List<SubscribedServiceModel> model;
    private final Context mContext;
    private final PicassoRepository picasso = new PicassoRepository();

    public HomeFragmentRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HomeFragmentRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.individual_subscribed_card , parent , false);
        return new HomeFragmentRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentRecyclerViewHolder holder, int position) {
        if(model!=null)
        {
            String filename = model.get(position).getLogoimage();
            picasso.getLogoImage(filename , holder.getSubscribedCardLogoImageView());
            holder.getSubscribedCardNameTextView().setText(model.get(position).getProvidername());
            holder.getSubscribedCardServiceNameTextView().setText(model.get(position).getServicename());
            if(model.get(position).isActive())
            {
                holder.getSubscribedCardActiveTextView().setVisibility(View.VISIBLE);
                holder.getSubscribedCardNotActiveTextView().setVisibility(View.GONE);
            }
            else {
                holder.getSubscribedCardActiveTextView().setVisibility(View.GONE);
                holder.getSubscribedCardNotActiveTextView().setVisibility(View.VISIBLE);
            }
            holder.itemView.setOnClickListener(v->{
                Intent intent = new Intent(mContext , SubscribedServiceActivity.class);
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

    public void notifyDataSetChanged(List<SubscribedServiceModel> model)
    {
        this.model = model;
        notifyDataSetChanged();
    }
}

class HomeFragmentRecyclerViewHolder extends RecyclerView.ViewHolder
{
    private final ImageView subscribedCardLogoImageView;
    private final TextView subscribedCardNameTextView , subscribedCardServiceNameTextView , subscribedCardActiveTextView , subscribedCardNotActiveTextView;
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
