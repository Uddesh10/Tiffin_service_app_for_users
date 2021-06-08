package com.uddesh.tiffinserviceapp.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.uddesh.tiffinserviceapp.R;

public class MainActivity extends AppCompatActivity {
    ImageView logo_image_imageview;
    Button sign_up_button, login_button, signup_up_form_signup_button, login_form_login_button, otp_verify_button;
    TextView app_name_text_view, or_text_view, login_form_signup_textview ,sign_up_form_already_have_account_textview, textView3, sign_up_form_login_textview, otp_mobile_textview, textview, textView2;
    EditText signup_form_full_name_edittext, sign_up_form_mobile_edit_text, signup_form_password_edit_text, login_form_username_edittext, login_form_password_edittext , otp_edittext1 ,otp_edittext4,otp_edittext5,otp_edittext2, otp_edittext3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo_image_imageview = findViewById(R.id.logo_image_view);
        app_name_text_view = findViewById(R.id.app_name_text_view);
        sign_up_button = findViewById(R.id.sign_up_button);
        login_button = findViewById(R.id.login_button);
        or_text_view = findViewById(R.id.or_text_view);
        signup_form_full_name_edittext = findViewById(R.id.signup_form_full_name_edittext);
        sign_up_form_already_have_account_textview = findViewById(R.id.signup_form_user_name_edit_text);
        sign_up_form_mobile_edit_text = findViewById(R.id.sign_up_form_mobile_edit_text);
        signup_form_password_edit_text = findViewById(R.id.signup_form_password_edit_text);
        signup_up_form_signup_button = findViewById(R.id.signup_up_form_signup_button);
        sign_up_form_already_have_account_textview = findViewById(R.id.sign_up_form_already_have_account_textview);
        sign_up_form_login_textview = findViewById(R.id.sign_up_form_login_textview);
        login_form_username_edittext = findViewById(R.id.login_form_username_edittext);
        login_form_login_button = findViewById(R.id.login_form_login_button);
        textView3 = findViewById(R.id.textView3);
        login_form_signup_textview = findViewById(R.id.login_form_signup_textview);
        login_form_password_edittext = findViewById(R.id.login_form_password_edittext);
        otp_mobile_textview = findViewById(R.id.otp_mobile_textview);
        otp_edittext1 = findViewById(R.id.otp_edittext1);
        otp_edittext4 = findViewById(R.id.otp_edittext4);
        otp_edittext5 = findViewById(R.id.otp_edittext5);
        otp_edittext2 = findViewById(R.id.otp_edittext2);
        otp_edittext3 = findViewById(R.id.otp_edittext3);
        otp_verify_button = findViewById(R.id.otp_verify_button);
        textview = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);






        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signup_up_form_signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        login_form_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        otp_verify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}