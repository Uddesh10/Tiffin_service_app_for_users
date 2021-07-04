package com.uddesh.tiffinserviceapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.annotation.OnSymbolDragListener;
import com.mapbox.mapboxsdk.plugins.annotation.Symbol;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.uddesh.tiffinserviceapp.BuildConfig;
import com.uddesh.tiffinserviceapp.DataModels.UserLocationModel;
import com.uddesh.tiffinserviceapp.Helpers.SharedPreferencesHelper;
import com.uddesh.tiffinserviceapp.Helpers.ToastHelper;
import com.uddesh.tiffinserviceapp.R;
import com.uddesh.tiffinserviceapp.Repository.RetrofitViewModel;
import java.util.List;


public class SetAddressActivity extends AppCompatActivity implements OnMapReadyCallback, PermissionsListener {
    private MapView setAddressMapView;
    private PermissionsManager permissionsManager;
    private MapboxMap mapboxMap;
    private Symbol symbol;
    private EditText setAddressTextView;
    private SharedPreferencesHelper sharedPreferences;
    private RetrofitViewModel viewModel;
    private String location;
    private double latitude , longitude;
    private ToastHelper toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, BuildConfig.MapBoxApiKey);
        setContentView(R.layout.activity_set_address);
        sharedPreferences = new SharedPreferencesHelper(this);
        viewModel = new RetrofitViewModel(getApplication());
        setAddressMapView =  findViewById(R.id.setAddressMapView);
        setAddressMapView.onCreate(savedInstanceState);
        setAddressMapView.getMapAsync(this);
        setAddressTextView = findViewById(R.id.setAddressTextView);
        Button setAddressButton = findViewById(R.id.setAddressButton);
        toast = new ToastHelper(this);
        setAddressButton.setOnClickListener(view -> {
            location = setAddressTextView.getText().toString();
            String username = sharedPreferences.getSharedPreferences("username");
            if(!location.equals("")) {
                viewModel.updateUserLocation(new UserLocationModel(location, latitude, longitude, username)).observe(this, result -> {
                    if (result!=null && result) {
                        toast.makeToast("Success", Toast.LENGTH_LONG);
                        Intent intent = new Intent(this, HomePageActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        toast.makeToast("Something went wrong", Toast.LENGTH_LONG);
                    }
                });
            }
            else{
              toast.makeToast("Enter the address" , Toast.LENGTH_LONG);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        setAddressMapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAddressMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        setAddressMapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        setAddressMapView.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setAddressMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        setAddressMapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setAddressMapView.onDestroy();
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(this::enableLocationComponent);
        } else {
            Toast.makeText(this, "Please grant permission to continue" , Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        SetAddressActivity.this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(Style.SATELLITE_STREETS, new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                enableLocationComponent(style);
                Location location = mapboxMap.getLocationComponent().getLastKnownLocation();
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                style.addImage("LOCATION_MARKER" , BitmapUtils.getBitmapFromDrawable(getResources().getDrawable(R.drawable.ic_location_marker)));
                SymbolManager symbolManager = new SymbolManager(setAddressMapView, mapboxMap, style);
                symbolManager.setIconAllowOverlap(true);
                symbolManager.setTextAllowOverlap(true);
                SymbolOptions symbolOptions = new SymbolOptions()
                        .withLatLng(new LatLng(latitude,longitude))
                        .withIconImage("LOCATION_MARKER")
                        .withIconSize(1.3f)
                        .withDraggable(true);
                symbol = symbolManager.create(symbolOptions);
                symbolManager.addDragListener(new OnSymbolDragListener() {
                    @Override
                    public void onAnnotationDragStarted(Symbol annotation) {

                    }

                    @Override
                    public void onAnnotationDrag(Symbol annotation) {

                    }

                    @Override
                    public void onAnnotationDragFinished(Symbol annotation) {
                        latitude = annotation.getLatLng().getLatitude();
                        longitude = annotation.getLatLng().getLongitude();
                    }
                });
            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    // Private functions
    @SuppressWarnings( {"MissingPermission"})
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {
        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            LocationComponent locationComponent = mapboxMap.getLocationComponent();
            locationComponent.activateLocationComponent(LocationComponentActivationOptions.builder(this, loadedMapStyle).build());
            locationComponent.setLocationComponentEnabled(true);
            locationComponent.setCameraMode(CameraMode.TRACKING);
            locationComponent.setRenderMode(RenderMode.COMPASS);
        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }
}