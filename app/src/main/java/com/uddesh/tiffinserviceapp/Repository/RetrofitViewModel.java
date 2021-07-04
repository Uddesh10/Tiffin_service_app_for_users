package com.uddesh.tiffinserviceapp.Repository;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.uddesh.tiffinserviceapp.DataModels.*;
import com.uddesh.tiffinserviceapp.Helpers.SharedPreferencesHelper;

import java.util.List;

public class RetrofitViewModel extends AndroidViewModel {
    private final SharedPreferencesHelper sharedPreferences;
    RetrofitRepository repository;
    public RetrofitViewModel(@NonNull Application application) {
        super(application);
        sharedPreferences = new SharedPreferencesHelper(application.getApplicationContext());
        repository = RetrofitRepository.getInstance();
    }

    public MutableLiveData<Boolean> userSignup(SignupModel model)
    {
        return repository.userSignup(model);
    }

    public MutableLiveData<LoggedInDataModel> userLogin(LoginModel model){
        return repository.userLogin(model);
    }

    public MutableLiveData<Boolean> updateUserLocation(UserLocationModel model)
    {
        String username = sharedPreferences.getSharedPreferences("username");
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        return repository.updateUserLocation(username , model , "Bearer "+authToken);
    }
    public MutableLiveData<Boolean> addSubscription(AddSubscriptionModel model)
    {
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        String username = sharedPreferences.getSharedPreferences("username");
        return repository.addSubscription(username, model , "Bearer "+authToken);
    }
    public MutableLiveData<Boolean> updateActive(int id , boolean active)
    {
        String username = sharedPreferences.getSharedPreferences("username");
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        return repository.updateActive(username , id , active , "Bearer "+authToken);
    }
    public MutableLiveData<Boolean> renewService(int id , int days)
    {
        String username = sharedPreferences.getSharedPreferences("username");
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        return repository.renewService(id , username , days , "Bearer "+authToken);
    }
    public MutableLiveData<List<SubscribedServiceModel>> getSubscribedService()
    {
        String username = sharedPreferences.getSharedPreferences("username");
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        return repository.getSubscribedService(username , "Bearer "+authToken);
    }
    public MutableLiveData<SubscribedServiceDetailsModel> getSubscribedServiceDetails(int id )
    {
        String username = sharedPreferences.getSharedPreferences("username");
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        return repository.getSubscribedServiceDetails(id , username , "Bearer "+authToken);
    }
    public MutableLiveData<List<GetAllServiceProviderModel>> getAllServiceProvider()
    {
        String username = sharedPreferences.getSharedPreferences("username");
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        return repository.getAllServiceProvider(username , "Bearer "+authToken);
    }
    public MutableLiveData<GetServiceProviderModel> getServiceProvider(String providerUsername)
    {
        String username = sharedPreferences.getSharedPreferences("username");
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        return repository.getServiceProvider(username , providerUsername , "Bearer "+authToken);
    }
    public MutableLiveData<GetServiceModel> getService(int id)
    {
        String username = sharedPreferences.getSharedPreferences("username");
        String authToken = sharedPreferences.getSharedPreferences("authToken");
        return repository.getService(id , username , "Bearer "+authToken);
    }

}
