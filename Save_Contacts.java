package com.example.monica.timebased;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Save_Contacts extends AppCompatActivity {

    EditText contact[]=new EditText[5];
    TextView name[]=new TextView[5];
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save__contacts);

        SharedPreferences shared=getSharedPreferences("Contact Details", Context.MODE_PRIVATE);


        contact[0]=(EditText)findViewById(R.id.contact1);
        contact[1]=(EditText)findViewById(R.id.contact2);
        contact[2]=(EditText)findViewById(R.id.contact3);
        contact[3]=(EditText)findViewById(R.id.contact4);
        contact[4]=(EditText)findViewById(R.id.contact5);

        name[0]=(TextView)findViewById(R.id.name1);
        name[1]=(TextView)findViewById(R.id.name2);
        name[2]=(TextView)findViewById(R.id.name3);
        name[3]=(TextView)findViewById(R.id.name4);
        name[4]=(TextView)findViewById(R.id.name5);


        Boolean check=shared.getBoolean("stored",false);
        if(check)
        {
            for(int i=0;i<5;i++)
            {
                contact[i].setText(shared.getString("Contact"+i,""));
                name[i].setText(shared.getString("Name"+i,""));
            }
        }
    }

    public void getContacts(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        startActivityForResult(intent, 1);
        index=0;

    }
    public void getContacts1(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        startActivityForResult(intent, 1);
        index=1;

    }
    public void getContacts2(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        startActivityForResult(intent, 1);
        index=2;

    }
    public void getContacts3(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        startActivityForResult(intent, 1);
        index=3;

    }
    public void getContacts4(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        startActivityForResult(intent, 1);
        index=4;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Uri contactData = data.getData();
            Cursor cursor =  managedQuery(contactData, null, null, null, null);
            cursor.moveToFirst();

            String number =       cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String name =       cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            //contactName.setText(name);
            contact[index].setText(number);
            this.name[index].setText(name);
            //contactEmail.setText(email);

        }
    }

    public void saveContacts(View view) {

        for(int j=0;j<5;j++)
        {
            SharedPreferences shared=getSharedPreferences("Contact Details", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=shared.edit();
            editor.putString("contacts","updated");
            editor.putString("Contact"+j,contact[j].getText().toString().replaceAll(" ",""));
            editor.putString("Name"+j,name[j].getText().toString());
            editor.putBoolean("stored",true);
            editor.commit();
            startActivity(new Intent(this,Home.class));
        }

        for(int k=0;k<5;k++)
        {
            SharedPreferences shared=getSharedPreferences("Contact Details", Context.MODE_PRIVATE);
            Toast.makeText(this, shared.getString("Contact"+k,""), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, shared.getString("Name"+k,""), Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "hai", Toast.LENGTH_SHORT).show();
        Boolean flag=true;
        for(int i=0;i<5;i++){
            if(TextUtils.isEmpty(contact[i].getText().toString())){
                flag=false;
            }
        }

        if(flag){
            SharedPreferences sp=getSharedPreferences("Contact Details",Context.MODE_PRIVATE);
            for(int i=0;i<5;i++){
                Toast.makeText(this,i+" "+ sp.getString("Contact"+i,""), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Enter 5 contacts", Toast.LENGTH_SHORT).show();
        }
    }
}
