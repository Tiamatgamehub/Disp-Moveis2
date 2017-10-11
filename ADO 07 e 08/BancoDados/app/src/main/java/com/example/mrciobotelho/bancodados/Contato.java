package com.example.mrciobotelho.bancodados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class Contato extends AppCompatActivity {
    ListView contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contato);
        setTitle("Lista de Contatos");
        contato = (ListView)findViewById(R.id.VContatos);
        puxarContatos();
    }


    void puxarContatos (){
        Cursor c = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID};
        int [] to = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, c, from, to, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        contato.setAdapter(adapter);

    }
}
