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
import com.uddesh.tiffinserviceapp.Activity.IndividualServiceProviderActivity;
import com.uddesh.tiffinserviceapp.DataModels.GetAllServiceProviderModel;
import com.uddesh.tiffinserviceapp.R;
import com.uddesh.tiffinserviceapp.Repository.PicassoRepository;

import java.util.List;

public class ServiceListFragmentRecyclerAdapter extends RecyclerView.Adapter<ServiceListFragmentRecyclerViewHolder>{
    private List<GetAllServiceProviderModel> model;
    private final Context mContext;
    private final PicassoRepository picasso = new PicassoRepository();

    public ServiceListFragmentRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ServiceListFragmentRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.individual_service_provider_card , parent , false);
        return new ServiceListFragmentRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceListFragmentRecyclerViewHolder holder, int position) {
        if(model!=null)
        {
            String fileName = model.get(position).getLogoimage();
            String distance = model.get(position).getDistance()+" Km";
            String price = "Price starting from "+model.get(position).getStartingprice()+" ₹/month";
            picasso.getLogoImage(fileName , holder.getServiceProviderCardLogoImageview());
            holder.getServiceProviderCardNameTextView().setText(model.get(position).getProvidername());
            holder.getServiceProviderCardAvailabilityTextView().setText(model.get(position).getAvailability());
            holder.getServiceProviderCardDistanceTextView().setText(distance);
            holder.getServiceProviderCardPriceTextView().setText(price);
            if(model.get(position).isVegnonveg())
            {
                holder.getServiceProviderCardVegTextView().setVisibility(View.VISIBLE);
                holder.getServiceProviderCardNonVegTextView().setVisibility(View.VISIBLE);
            }
            else
            {
                holder.getServiceProviderCardVegTextView().setVisibility(View.VISIBLE);
                holder.getServiceProviderCardNonVegTextView().setVisibility(View.GONE);
            }
            holder.itemView.setOnClickListener(v->{
                Intent intent = new Intent(mContext , IndividualServiceProviderActivity.class);
                intent.putExtra("providerName" , model.get(position).getUsername());
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

    public void notifyDataSetChanged(List<GetAllServiceProviderModel> model)
    {
        this.model = model;
        notifyDataSetChanged();
    }
}

class ServiceListFragmentRecyclerViewHolder extends RecyclerView.ViewHolder
{
    private final ImageView serviceProviderCardLogoImageview;
    private final TextView serviceProviderCardNameTextView,serviceProviderCardVegTextView , serviceProviderCardNonVegTextView ,serviceProviderCardDistanceTextView , serviceProviderCardAvailabilityTextView , serviceProviderCardPriceTextView;
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
