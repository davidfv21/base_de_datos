package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.utilidades.utilidades;

public class conexionsqlitehelper extends SQLiteOpenHelper {


    public conexionsqlitehelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(utilidades.CREARTABLAUSUARIO);
        //generar las tablas de la bd

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int Versionantigua, int Versionnueva) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");//si encuentra una version antigua la elimine y vuelva a crarla
        onCreate(db);

//verifica las versines antiguas de la bd y las refresca
    }
}
//permite conectar la base de datos