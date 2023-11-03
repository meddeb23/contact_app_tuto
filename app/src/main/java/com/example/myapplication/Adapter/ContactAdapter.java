package com.example.myapplication.Adapter;
import com.example.myapplication.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Models.Contact;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    ArrayList<Contact> data;
    Context con;

    public ContactAdapter(Context con,ArrayList<Contact> data) {
        this.data = data;
        this.con = con;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        // create view
        LayoutInflater inf= LayoutInflater.from(con);
        LinearLayout l=(LinearLayout) inf.inflate(R.layout.contact_item,null);

        // get view elements by ids
        TextView name_tv = l.findViewById(R.id.name_contact_item);
        TextView number_tv = l.findViewById(R.id.phone_contact_item);
        ImageView deleteButton = l.findViewById(R.id.delete_btn);
        ImageView callButton = l.findViewById(R.id.call_btn);

        Contact c =data.get(position);

      deleteButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toast.makeText(con, "delete item", Toast.LENGTH_SHORT).show();
              data.remove(position);
              notifyDataSetChanged();
          }
      });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri phoneCallUri = Uri.parse("tel:"+c.getNumber());
                Intent phoneCallIntent= new Intent(Intent.ACTION_DIAL);
                phoneCallIntent.setData(phoneCallUri);
                con.startActivity(phoneCallIntent);

                Toast.makeText(con, "call number", Toast.LENGTH_SHORT).show();
            }
        });

        //affecter les valeur
        name_tv.setText(c.getFirst_name() + " " +c.getLast_name());
        number_tv.setText(c.getNumber());

        return l;
    }

    public void filter(String query){
        for (Contact item:data) {

        }
    }

}
