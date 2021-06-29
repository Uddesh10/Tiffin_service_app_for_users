package com.uddesh.tiffinserviceapp.Repository;

import com.uddesh.tiffinserviceapp.DataModels.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ApiCalls {


    @POST("usersignup")
    Call<ResponseBody> userSignup(@Body SignupModel model);

    @POST("userlogin")
    Call<ResponseBody> userLogin(@Body LoginModel model);

    @PUT("userlocation")
    Call<ResponseBody> updateUserLocation(@Query("username") String username , @Body UserLocationModel model , @Header("Authorization") String token);

    @POST("addsubscription")
    Call<ResponseBody> addSubscription(@Body AddSubscriptionModel model , @Header("Authorization") String token);

    @PUT("updateactive")
    Call<ResponseBody> updateActive(@Query("username") String username , @Query("id") int id , @Query("active") boolean active , @Header("Authorization") String token);

    @PUT("renewservice")
    Call<ResponseBody> renewService(@Query("id") int id , @Query("username") String username , @Query("days") int days , @Header("Authorization") String token);

    @GET("subscribedservice")
    Call<List<SubscribedServiceModel>> getSubscribedService(@Query("username") String username , @Header("Authorization") String token);

    @GET("subscribedservicedetails")
    Call<List<SubscribedServiceDetailsModel>> getSubscribedServiceDetails(@Query("id") int id  , @Query("username") String username , @Header("Authorization") String token);

    @GET("getallserviceprovider")
    Call<List<GetAllServiceProviderModel>> getAllServiceProvider(@Query("username") String username , @Header("Authorization") String token);

    @GET("getserviceprovider")
    Call<List<GetServiceProviderModel>> getServiceProvider(@Query("username") String username ,@Query("providerUsername") String providerUsername , @Header("Authorization") String token);

    @GET("getservice")
    Call<List<GetServiceModel>> getService(@Query("id") int id , @Query("username") String username , @Header("Authorization") String token);

}
