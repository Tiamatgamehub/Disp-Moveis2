package com.example.mrciobotelho.bancodados;
import android.content.Context;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Márcio Botelho on 12/09/2017.
 */

public class DataBase {
    private SQLiteDatabase db;

    public DataBase (Context context){
        Core databaseSettings = new Core(context);
        this.db = databaseSettings.getWritableDatabase();

    }
    public void doNoQuery (String query){
        this.db.execSQL(query);
    }


    public String [][] doQuery(String query){
        Cursor queryResult = this.db.rawQuery(query, null);
        int columCount = queryResult.getColumnCount();
        int rowsCount = queryResult.getCount();

        String [][] result = new String [rowsCount][columCount];

        for (int i = 0; i<rowsCount; i++){
            queryResult.moveToNext();
            for (int j=0; j<columCount; j++){
                result[i][j]=queryResult.getString(j);
            }

        }
        return result;
    }

}
