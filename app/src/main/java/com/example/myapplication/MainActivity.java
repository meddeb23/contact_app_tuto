package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnExit;
    EditText etEmail;
    EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the XML into the screen
        setContentView(R.layout.activity_main);
        // get a component from XML
        btnLogin = findViewById(R.id.btnlogin_auth);
        btnExit = findViewById(R.id.btnexit_auth);
        etEmail = findViewById(R.id.edtemail_auth);
        etPwd = findViewById(R.id.edtpwd_auth);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPwd.getText().toString();
                if(email.equals("email") && password.equals("pwd")){
                    // route to another activity
                    routeToFeedActivity(view);
                    System.out.println("testing");
                System.out.println(String.format("login with \nemail {}\npassword {}", email, password));
                }else{
                    Toast.makeText(MainActivity.this, "error",Toast.LENGTH_SHORT);
                }
            }
        });
    }

    public void routeToFeedActivity(View view) {
        Intent intent = new Intent(this, Feed.class);
        startActivity(intent);
    }
}