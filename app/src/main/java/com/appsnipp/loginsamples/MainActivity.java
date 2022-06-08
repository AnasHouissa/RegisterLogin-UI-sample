package com.appsnipp.loginsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private TextView tv_Login, tv_reg;
    private ViewFlipper viewfilpper;
    private Button loginBtn, registerBtn;
    private EditText et_email_login, et_password_login,
            et_pwd_reg,et_number_reg,et_email_reg,et_name_reg;
    private TextInputLayout email_lay_log, pwd_lay_log
            ,name_lay_reg,pwd_lay_reg,email_lay_reg,number_lay_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //common views
        viewfilpper = (ViewFlipper) findViewById(R.id.viewfilpper);

        //login layout views
        tv_reg = (TextView) findViewById(R.id.tv_reg);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        et_email_login = (EditText) findViewById(R.id.et_email_login);
        et_password_login = (EditText) findViewById(R.id.et_password_login);
        email_lay_log = (TextInputLayout) findViewById(R.id.email_lay_log);
        pwd_lay_log = (TextInputLayout) findViewById(R.id.pwd_lay_log);

        //register layout views
        tv_Login = (TextView) findViewById(R.id.tv_Login);
        et_pwd_reg = (EditText) findViewById(R.id.et_pwd_reg);
        et_number_reg = (EditText) findViewById(R.id.et_number_reg);
        et_email_reg = (EditText) findViewById(R.id.et_email_reg);
        et_name_reg = (EditText) findViewById(R.id.et_name_reg);
        name_lay_reg = (TextInputLayout) findViewById(R.id.name_lay_reg);
        pwd_lay_reg = (TextInputLayout) findViewById(R.id.pwd_lay_reg);
        email_lay_reg = (TextInputLayout) findViewById(R.id.email_lay_reg);
        number_lay_reg = (TextInputLayout) findViewById(R.id.number_lay_reg);
        registerBtn = (Button) findViewById(R.id.registerBtn);


        // display the login layout
        tv_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewfilpper.setDisplayedChild(1);
            }
        });

        // display the registration layout
        tv_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewfilpper.setDisplayedChild(0);
            }
        });

        // login
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_email_login.getText().toString().isEmpty() ||
                        !et_email_login.getText().toString().matches("^(.+)@(.+)$")) { //email regex
                    //display error
                    email_lay_log.setError(getString(R.string.email_error));
                } else {
                    // remove error
                    email_lay_log.setError(null);
                }
                if (et_password_login.getText().toString().length() < 8) {
                    pwd_lay_log.setError(getString(R.string.pwd_error));
                } else {
                    pwd_lay_log.setError(null);
                }
                if(pwd_lay_log.getError()==null && email_lay_log.getError()==null){
                    //login
                    Intent intent=new Intent(getApplicationContext(),Accueil.class);
                    startActivity(intent);
                }

            }
        });

        // register
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_name_reg.getText().toString().isEmpty() ||
                        et_name_reg.getText().toString().matches("^.*([0-9]+).*$")){ //digit regex text1text example
                    //display error
                    name_lay_reg.setError(getString(R.string.nameError));
                } else {
                    // remove error
                    name_lay_reg.setError(null);
                }
                if (et_number_reg.getText().toString().isEmpty() ||
                        !et_number_reg.getText().toString().matches("^[0-9]+$")) { //all digits regex
                    //display error
                    number_lay_reg.setError(getString(R.string.numberError));
                } else {
                    // remove error
                    number_lay_reg.setError(null);
                }
                if (et_email_reg.getText().toString().isEmpty() ||
                        !et_email_reg.getText().toString().matches("^(.+)@(.+)$")) { //email regex
                    //display error
                    email_lay_reg.setError(getString(R.string.email_error));
                } else {
                    // remove error
                    email_lay_reg.setError(null);
                }
                if (et_pwd_reg.getText().toString().length() < 8) {
                    pwd_lay_reg.setError(getString(R.string.pwd_error));
                } else {
                    pwd_lay_reg.setError(null);
                }
                if(pwd_lay_reg.getError()==null && email_lay_reg.getError()==null && number_lay_reg.getError()==null && name_lay_reg.getError()==null){
                    //register
                    viewfilpper.setDisplayedChild(1);
                }

            }
        });

    }
}
