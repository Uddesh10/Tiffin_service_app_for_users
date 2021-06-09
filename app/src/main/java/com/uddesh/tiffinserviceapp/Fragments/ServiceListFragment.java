package com.uddesh.tiffinserviceapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uddesh.tiffinserviceapp.Adapters.ServiceListFragmentRecyclerAdapter;
import com.uddesh.tiffinserviceapp.R;

public class ServiceListFragment extends Fragment {
    RecyclerView recyclerView;
    ServiceListFragmentRecyclerAdapter serviceListFragmentRecyclerAdapterInstance;
    public ServiceListFragment() {
        // Required empty public constructor
    }


    public static ServiceListFragment newInstance() {
        return new ServiceListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.service_list_recyclerview);
        serviceListFragmentRecyclerAdapterInstance = new ServiceListFragmentRecyclerAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager( getContext() ,LinearLayoutManager.VERTICAL , false));
        recyclerView.setAdapter(serviceListFragmentRecyclerAdapterInstance);
    }
}