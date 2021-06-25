package com.uddesh.tiffinserviceapp.Helpers;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.*;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.uddesh.tiffinserviceapp.Activity.SetAddressActivity;

import java.util.concurrent.TimeUnit;

public class OtpVerification {
    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String verificationId;
    private final Activity activity;

    public OtpVerification(Activity activity) {
        this.activity = activity;
    }

    public void sendVerificationCode(String number) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(number)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(activity)
                        .setCallbacks(mCallBack)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

        }

        @Override
        public void onCodeSent(@NonNull String code, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
           verificationId = code;
        }
    };

    public void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Intent intent = new Intent(activity , SetAddressActivity.class);
                        activity.startActivity(intent);
                    }
                    else{
                        Log.i("data" , "failure");
                    }
                });
    }
}
