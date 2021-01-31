package com.example.financas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static int DB_VERSION = 1;
    public static String DB_NAME = "FINANCAS.DB";
    public static String TABLE_NAME = "OPERACOES";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + " ( id_operacao INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "tp_operacao TEXT NOT NULL,"
                + "op_desc TEXT NOT NULL,"
                + "dt_operacao INTEGER NOT NULL,"
                + "valor_operacao FLOAT NOT NULL ); ";

        try {
            sqLiteDatabase.execSQL(CREATE_SQL);
            Log.i("INFO DB", "Tabela criada.");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao criar tabela." + e.getMessage());
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        try {
            sqLiteDatabase.execSQL(sql);
            onCreate(sqLiteDatabase);
            Log.i("INFO DB", "Tabela atualizada.");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao atualizar tabela." + e.getMessage());
        }

    }
}

