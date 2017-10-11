package com.example.mrciobotelho.bancodados;
import android.content.Context;
import android.database.sqlite.*;

/**
 * Created by Márcio Botelho on 12/09/2017.
 */

public class Core extends SQLiteOpenHelper {

    private static final String banco = "Lista.db";
    private static final int bancoVer = 1;
    private static final String user = "Usuarios";


    public Core(Context context) {
        super(context, banco, null, bancoVer);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String comando = "CREATE TABLE "+user+" ('id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " 'name' TEXT, 'email' TEXT, 'senha' TEXT)";
        db.execSQL(comando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String limpar = "DROP TABLE '" +user+"'";
        db.execSQL(limpar);
        onCreate(db);
    }
}
