package com.example.myapplication.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CreateContact;
import com.example.myapplication.Feed;
import com.example.myapplication.Models.Contact;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ContactRecycleAdapter extends RecyclerView.Adapter<ContactRecycleAdapter.MyViewHolder> {

    ArrayList<Contact> data;
    Context con;

    public ContactRecycleAdapter(Context con,ArrayList<Contact> data) {
        this.data = data;
        this.con = con;
    }

    @NonNull
    @Override
    public ContactRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create view
        LayoutInflater inf= LayoutInflater.from(con);
        LinearLayout l=(LinearLayout) inf.inflate(R.layout.contact_item,null);
        MyViewHolder viewHolder = new MyViewHolder(l);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactRecycleAdapter.MyViewHolder holder, int position) {
        Contact c =data.get(position);

        // assign values
        holder.name_tv.setText(c.getFirst_name() + " " +c.getLast_name());
        holder.number_tv.setText(c.getNumber());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_tv;
        TextView number_tv;
        ImageView deleteButton;
        ImageView editButton;
        ImageView callButton;

        AlertDialog alert = null;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // get view elements by ids
            name_tv = itemView.findViewById(R.id.name_contact_item);
            number_tv = itemView.findViewById(R.id.phone_contact_item);
            deleteButton = itemView.findViewById(R.id.delete_btn);
            callButton = itemView.findViewById(R.id.call_btn);
            editButton = itemView.findViewById(R.id.edit_btn);




            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Contact contact = data.get(position);
                    System.out.println("edit contact " + contact);
                    AlertDialog.Builder editAlert = new AlertDialog.Builder(con);
                    editAlert.setTitle("Edit contact");
                    LayoutInflater inf= LayoutInflater.from(con);
                    LinearLayout linearLayout = (LinearLayout) inf.inflate(R.layout.edit_modal,null);

                    EditText first_name = linearLayout.findViewById(R.id.edt_first_name_edit);
                    first_name.setText(contact.getFirst_name());
                    EditText last_name = linearLayout.findViewById(R.id.edt_last_name_edit);
                    last_name.setText(contact.getLast_name());
                    EditText phone_number = linearLayout.findViewById(R.id.edt_phone_edit);
                    phone_number.setText(contact.getNumber());

                    Button cancelBtn = linearLayout.findViewById(R.id.btn_cancel_edit);
                    Button updateBtn = linearLayout.findViewById(R.id.btn_update_contact_edit);

                    cancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            alert.dismiss();
                        }
                    });

                    updateBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String first_name_text = first_name.getText().toString();
                            String last_name_text = last_name.getText().toString();
                            String phone_number_text = phone_number.getText().toString();
                            if(first_name_text.length() == 0 && last_name_text.length() == 0 && phone_number_text.length() == 0){
                                Toast.makeText(con, "Please Fill all forms", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            contact.setFirst_name(first_name_text);
                            contact.setLast_name(last_name_text);
                            contact.setNumber(phone_number_text);
                            notifyDataSetChanged();
                            alert.dismiss();
                        }
                    });

                    editAlert.setView(linearLayout);
                    alert = editAlert.create();
                    alert.show();

                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition(); // index of selected element
                    Toast.makeText(con, "delete item", Toast.LENGTH_SHORT).show();
                    data.remove(position);
                    notifyDataSetChanged();
                }
            });

            callButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition(); // index of selected element
                    Contact contact = data.get(position);
                    Uri phoneCallUri = Uri.parse("tel:"+ contact.getNumber());
                    Intent phoneCallIntent= new Intent(Intent.ACTION_DIAL);
                    phoneCallIntent.setData(phoneCallUri);
                    con.startActivity(phoneCallIntent);

                    Toast.makeText(con, "call number", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
