package com.uddesh.tiffinserviceapp.Repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.uddesh.tiffinserviceapp.DataModels.*;
import com.uddesh.tiffinserviceapp.Helpers.RetrofitHelper;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class RetrofitRepository {
    RetrofitHelper retrofitHelper = new RetrofitHelper();
    private static RetrofitRepository retrofitRepository;
    public static RetrofitRepository getInstance()
    {
        if(retrofitRepository==null)
        {
            retrofitRepository = new RetrofitRepository();
        }
        return retrofitRepository;
    }

    public MutableLiveData<Boolean> userSignup(SignupModel model)
    {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.userSignup(model).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(response.isSuccessful())
                {
                    data.setValue(true);
                }
                else{
                    data.setValue(false);
                }
            }
            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<LoggedInDataModel> userLogin(LoginModel model)
    {
        MutableLiveData<LoggedInDataModel> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.userLogin(model).enqueue(new Callback<LoggedInDataModel>() {
            @Override
            public void onResponse(@NonNull Call<LoggedInDataModel> call, @NonNull Response<LoggedInDataModel> response) {
                    if(response.isSuccessful()){
                        data.setValue(response.body());
                    }
                    else
                        data.setValue(null);

                }
            @Override
            public void onFailure(@NonNull Call<LoggedInDataModel> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<Boolean> updateUserLocation(String username , UserLocationModel model , String authToken)
    {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.updateUserLocation(username , model , authToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(response.isSuccessful())
                {
                    data.setValue(true);
                }
                else{
                    data.setValue(false);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<Boolean> addSubscription(String username,AddSubscriptionModel model , String authToken)
    {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.addSubscription(username ,model , authToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(response.isSuccessful())
                {
                    data.setValue(true);
                }
                else{
                    data.setValue(false);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<Boolean> updateActive(String username , int id , boolean active , String authToken)
    {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.updateActive(username , id , active , authToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(response.isSuccessful())
                {
                    data.setValue(true);
                }
                else{
                    data.setValue(false);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<Boolean> renewService(int id , String username , int days , String authToken)
    {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.renewService(id , username , days , authToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if(response.isSuccessful())
                {
                    data.setValue(true);
                }
                else {
                    data.setValue(false);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<List<SubscribedServiceModel>> getSubscribedService(String username , String authToken)
    {
        MutableLiveData<List<SubscribedServiceModel>> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.getSubscribedService(username , authToken).enqueue(new Callback<List<SubscribedServiceModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<SubscribedServiceModel>> call, @NonNull Response<List<SubscribedServiceModel>> response) {
                if(response.isSuccessful())
                {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<SubscribedServiceModel>> call, @NonNull Throwable t) {

            }
        });
        return data;
    }

    public MutableLiveData<SubscribedServiceDetailsModel> getSubscribedServiceDetails(int id , String username , String authToken)
    {
        MutableLiveData<SubscribedServiceDetailsModel> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.getSubscribedServiceDetails(id , username , authToken).enqueue(new Callback<List<SubscribedServiceDetailsModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<SubscribedServiceDetailsModel>> call, @NonNull Response<List<SubscribedServiceDetailsModel>> response) {
                if(response.isSuccessful())
                {
                    data.setValue(response.body().get(0));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<SubscribedServiceDetailsModel>> call, @NonNull Throwable t) {

            }
        });
        return data;
    }

    public MutableLiveData<List<GetAllServiceProviderModel>> getAllServiceProvider(String username , String authToken)
    {
        MutableLiveData<List<GetAllServiceProviderModel>> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.getAllServiceProvider(username , authToken).enqueue(new Callback<List<GetAllServiceProviderModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<GetAllServiceProviderModel>> call, @NonNull Response<List<GetAllServiceProviderModel>> response) {
                if(response.isSuccessful())
                {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<GetAllServiceProviderModel>> call, @NonNull Throwable t) {

            }
        });
        return data;
    }

    public MutableLiveData<GetServiceProviderModel> getServiceProvider(String username , String providerUsername , String authToken)
    {
        MutableLiveData<GetServiceProviderModel> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.getServiceProvider(username , providerUsername , authToken).enqueue(new Callback<List<GetServiceProviderModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<GetServiceProviderModel>> call, @NonNull Response<List<GetServiceProviderModel>> response) {
                if(response.isSuccessful())
                {
                    data.setValue(response.body().get(0));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<GetServiceProviderModel>> call, @NonNull Throwable t) {

            }
        });
        return data;
    }

    public MutableLiveData<GetServiceModel> getService(int id , String username , String authToken)
    {
        MutableLiveData<GetServiceModel> data = new MutableLiveData<>();
        retrofitHelper.apiCalls.getService(id , username , authToken).enqueue(new Callback<List<GetServiceModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<GetServiceModel>> call, @NonNull Response<List<GetServiceModel>> response) {
                if(response.isSuccessful())
                {
                    data.setValue(response.body().get(0));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<GetServiceModel>> call, @NonNull Throwable t) {

            }
        });
        return data;
    }
}
