package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.utilidades.utilidades;


public class consultarusuarios extends AppCompatActivity {
    EditText campoid,camponombre,campotelefono;
    conexionsqlitehelper conn;

    protected void onCreate(Bundle saveInstaceState){
        super.onCreate(saveInstaceState);
        setContentView(R.layout.activity_consultarusuario);

        conn=new conexionsqlitehelper(getApplicationContext(),"db usuarios ",null,1);

        campoid=(EditText)findViewById(R.id.editText4);
        camponombre=(EditText)findViewById(R.id.editText);
        campotelefono=(EditText)findViewById(R.id.editText2);

    }

    public void onClick (View View){

        switch (View.getId()){
            case R.id.ButConsult:
            consultar();
            break ;
        }

    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();


   //String parametros = (campoid .getText().toString());
    //String[] campos = (utilidades.campo_nombre , utilidades.campo_telefono);






        String []parametros=new String[10];
        parametros[0]=(campoid.getText().toString());


     String []campos =new String[10];
       campos[0]  =(utilidades.campo_nombre );

          //String[]campos =new String[10];
          //campos[0]=(utilidades.campo_telefono);


        //consula de campos

        try {
            Cursor cursor=  db.query(utilidades.tablausuario,campos,utilidades.campo_id+"=?",parametros,null,null,null);
            //se realiza la consulta

            cursor.moveToFirst();
            camponombre.setText(cursor.getString(0));
            campotelefono.setText(cursor.getString(1));
            cursor.close();
        //devuelve los datos
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"el documento no existe",Toast.LENGTH_LONG).show();
        limpiar();
        }


    }

    private void limpiar() {
        camponombre.setText("");
        campotelefono.setText("");
    }
}
