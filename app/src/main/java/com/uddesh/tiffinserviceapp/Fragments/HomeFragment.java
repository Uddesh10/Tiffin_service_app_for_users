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

import com.uddesh.tiffinserviceapp.Adapters.HomeFragmentRecyclerAdapter;
import com.uddesh.tiffinserviceapp.R;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    HomeFragmentRecyclerAdapter homeFragmentRecyclerAdapterInstance;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.home_fragment_recyclerview);
        homeFragmentRecyclerAdapterInstance = new HomeFragmentRecyclerAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager( getContext() ,LinearLayoutManager.VERTICAL , false));
        recyclerView.setAdapter(homeFragmentRecyclerAdapterInstance);
    }
}