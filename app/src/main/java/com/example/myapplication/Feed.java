package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.Adapter.ContactAdapter;
import com.example.myapplication.Adapter.ContactRecycleAdapter;
import com.example.myapplication.Models.Contact;

import java.util.ArrayList;

public class Feed extends AppCompatActivity {

    public static ArrayList<Contact> data = new ArrayList<>();
    Button add_contact_btn;
    RecyclerView contact_recycle_view;
    EditText search_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        add_contact_btn = findViewById(R.id.addBtn);
        contact_recycle_view = findViewById(R.id.contact_listView);
//        search_field = findViewById(R.id.search_field_feed);

        data.add(new Contact("Alice", "Johnson", "55512345"));
        data.add(new Contact("Bob", "Smith", "55567890"));
        data.add(new Contact("Eva", "Martinez", "55523456"));
        data.add(new Contact("David", "Taylor", "55578901"));
        data.add(new Contact("Sophie", "Brown", "55534567"));
        data.add(new Contact("Ryan", "Davis", "55589012"));
        data.add(new Contact("Olivia", "White", "55545678"));
        data.add(new Contact("Michael", "Lee", "55590123"));
        data.add(new Contact("Emma", "Miller", "55556789"));
        data.add(new Contact("Daniel", "Clark", "55567891"));
        data.add(new Contact("Grace", "Turner", "55578902"));
        data.add(new Contact("Nathan", "Evans", "55589013"));
        data.add(new Contact("Ava", "Harris", "55590124"));
        data.add(new Contact("Jordan", "Martinez", "55501234"));
        data.add(new Contact("Lily", "Thompson", "55512346"));
        data.add(new Contact("Andrew", "Baker", "55523457"));
        data.add(new Contact("Zoe", "Garcia", "55534568"));
        data.add(new Contact("Christopher", "Allen", "55545679"));
        data.add(new Contact("Mia", "Johnson", "55556780"));
        data.add(new Contact("Tyler", "Davis", "55567892"));

//        ArrayAdapter<Contact> ad = new ArrayAdapter(Feed.this, android.R.layout.simple_list_item_1,data);
//        contact_listView.setAdapter(ad);
//        ContactAdapter ad = new ContactAdapter(Feed.this,data);
        ContactRecycleAdapter contactRecycleAdapter = new ContactRecycleAdapter(Feed.this,data);
        GridLayoutManager manager = new GridLayoutManager(
                this, 1, GridLayoutManager.VERTICAL, false
        );
        contact_recycle_view.setLayoutManager(manager);
        contact_recycle_view.setAdapter(contactRecycleAdapter);

        add_contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info Tag", "data");
                routeToCreateContactActivity(view);
            }
        });

    }
    public void routeToCreateContactActivity(View view) {
        Intent intent = new Intent(this, CreateContact.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        contact_recycle_view.invalidate();
    }
}