package com.example.mrciobotelho.bancodados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {
    EditText name_user;
    EditText mails_user;
    EditText senha_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        name_user = (EditText)findViewById(R.id.name_user);
        mails_user = (EditText)findViewById(R.id.mails_user);
        senha_user = (EditText)findViewById(R.id.senha_user);
    }

    public void cadastrar (View view){
        String name = name_user.getText().toString().trim();
        String mail = mails_user.getText().toString().trim();
        String senha = senha_user.getText().toString().trim();
        DataBase db = new DataBase(this);
        String cadastra = "INSERT INTO Usuarios(id, name, email, senha) VALUES  (NULL, '" +name+ "', '"+mail+"','"+senha+"')";
        String cad = "INSERT INTO Usuarios(id, name, email, senha) VALUES (NULL, '"+name+"', '"+mail+"', '"+senha+"')";
        db.doNoQuery(cad);
        finish();
    }
}
