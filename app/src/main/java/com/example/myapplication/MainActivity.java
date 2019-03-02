package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public abstract class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    conexionsqlitehelper conn = new conexionsqlitehelper(this,"bd_usuarios",null,1);

    }

    public  void onClick(View View) {
        Intent miIntent=null;

        switch (View.getId()){
            case R.id.btonopcionregistro:
                miIntent=new Intent(MainActivity.this,registrousuarios.class);

                break;
            case R.id.conslt:
                miIntent=new Intent(MainActivity.this,consultarusuarios.class);

        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }





}
