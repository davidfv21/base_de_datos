package com.example.myapplication;

import android.app.AppComponentFactory;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.utilidades.utilidades;

public class registrousuarios extends AppCompatActivity {

    EditText campoid,camponombre,campotelefono;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoid= (EditText)findViewById(R.id.editText);
        camponombre=(EditText)findViewById(R.id.editText2);
        campotelefono=(EditText)findViewById(R.id.editText3);
        //capturar la iformacion de los campos del formulario
    }

    public void onClick(View V){
        registrarusuarios();
    }
//almacenar los usarios en bd
    private void registrarusuarios() {
        conexionsqlitehelper conn = new conexionsqlitehelper(this,"db usuarios",null,1);
        SQLiteDatabase db=conn.getWritableDatabase();
        //abrir base de datos para editar


        ContentValues values=new ContentValues();
        values.put(utilidades.campo_id,campoid.getText().toString());
        values.put(utilidades.campo_nombre,camponombre.getText().toString());
        values.put(utilidades.campo_telefono,campotelefono.getText().toString());
        //agregar una clave y un valor a los campos de bd

        Long idresultante=db.insert(utilidades.tablausuario,utilidades.campo_id,values);
        Toast.makeText(getApplicationContext(),"id registro :" +idresultante,Toast.LENGTH_SHORT).show();
        db.close();
    //insertar en la bd

    }
}
