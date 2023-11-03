package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Models.Contact;

public class CreateContact extends AppCompatActivity {
    
    Button add_contact_btn, go_back_btn;
    EditText first_name_edt;
    EditText last_name_edt;
    EditText phone_edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        add_contact_btn = findViewById(R.id.btn_add_contact);
        go_back_btn = findViewById(R.id.btn_go_back_create_contact);
        first_name_edt = findViewById(R.id.edt_first_name);
        last_name_edt = findViewById(R.id.edt_last_name);
        phone_edt = findViewById(R.id.edt_phone);

        add_contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = first_name_edt.getText().toString();
                String last_name = last_name_edt.getText().toString();
                String phone_number = phone_edt.getText().toString();
                if(first_name.length() == 0 && last_name.length() == 0 && phone_number.length() == 0){
                    Toast.makeText(CreateContact.this, "Please Fill all forms", Toast.LENGTH_SHORT).show();
                    return;
                }
                Contact c = new Contact(first_name, last_name, phone_number);
                Feed.data.add(c);
                finish();
            }
        });
        go_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}