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
    ImageView tab_imageview;
    Button button;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_imageview = findViewById(R.id.logo_image_view);
        textView = findViewById(R.id.app_name_text_view);
        button = findViewById(R.id.sign_up_button);
        button = findViewById(R.id.login_button);
        textView = findViewById(R.id.or_text_view);
        editText = findViewById(R.id.signup_form_full_name_edittext);
        editText = findViewById(R.id.signup_form_user_name_edit_text);
        editText = findViewById(R.id.sign_up_form_mobile_edit_text);
        editText = findViewById(R.id.signup_form_password_edit_text);
        button = findViewById(R.id.signup_up_form_signup_button);
        textView = findViewById(R.id.sign_up_form_already_have_account_textview);
        textView = findViewById(R.id.login_form_signup_textview);
        editText = findViewById(R.id.login_form_username_edittext);
        button = findViewById(R.id.login_form_login_button);
        textView = findViewById(R.id.textView3);
        textView = findViewById(R.id.login_form_signup_textview);
        editText = findViewById(R.id.login_form_password_edittext);
        textView = findViewById(R.id.otp_mobile_textview);
        editText = findViewById(R.id.otp_edittext1);
        editText = findViewById(R.id.otp_edittext4);
        editText = findViewById(R.id.otp_edittext5);
        editText = findViewById(R.id.otp_edittext2);
        editText = findViewById(R.id.otp_edittext3);
        button = findViewById(R.id.otp_verify_button);
        textView = findViewById(R.id.textView);
        textView = findViewById(R.id.textView2);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}