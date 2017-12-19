package com.example.dell.recyclerview17;

import android.app.Activity;
import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

   // ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);


        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Contact contact;
        for (int i = 1; i < 1000; i++) {
            contact = new Contact("name" + i, "phone" + i, android.R.drawable.ic_menu_call);
            contacts.add(contact);
        }

        ContactsAdapter adapter = new ContactsAdapter(this, contacts);

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));

    }


    public class Contact {
        public String name;
        public String phone;
        public int image;


        public Contact(String name, String phone, int image) {
            this.name = name;
            this.phone = phone;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }


    public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {


        private List<Contact> Contacts;

        private Context Context;


        public ContactsAdapter(Context context, List<Contact> contacts) {
            Contacts = contacts;
            Context = context;
        }


        private Context getContext() {
            return Context;
        }


        @Override
        public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);


            View contactView = inflater.inflate(R.layout.sub_layout, parent, false);


            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;

        }

        @Override
        public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, int position) {
            Contact contact = Contacts.get(position);

            viewHolder.name.setText(contact.getName());
            viewHolder.phone.setText(contact.getPhone());
            viewHolder.imgbtn.setImageResource(contact.getImage());


        }

        @Override
        public int getItemCount() {
            return Contacts.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView name;
            public TextView phone;
            public ImageButton imgbtn;


            public ViewHolder(View itemView) {

                super(itemView);

                name = (TextView) itemView.findViewById(R.id.text_name);
                phone = (TextView) itemView.findViewById(R.id.text_phonenumber);
                imgbtn = (ImageButton) itemView.findViewById(R.id.image);
            }
        }
    }

}

