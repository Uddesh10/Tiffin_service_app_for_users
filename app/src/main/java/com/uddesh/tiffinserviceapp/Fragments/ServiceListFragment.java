package com.uddesh.tiffinserviceapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uddesh.tiffinserviceapp.R;

public class ServiceListFragment extends Fragment {

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
}