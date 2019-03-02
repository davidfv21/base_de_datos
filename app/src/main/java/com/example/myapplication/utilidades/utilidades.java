package com.example.myapplication.utilidades;

public class utilidades {

    public static final String tablausuario="usuario";
    public static final String campo_id="id";
    public static final String campo_nombre="nombre";
    public static final String campo_telefono="telefono";
    //constantes campos de tabla de usuario


    public static final String CREARTABLAUSUARIO  ="CREATE TABLE "+tablausuario+" ("+campo_id+" INTEGER , "+campo_nombre+" text, "+campo_telefono+" text  ) ";
    //sentencia para crear base de datos

}
//constantes campos para la tabla de usuario