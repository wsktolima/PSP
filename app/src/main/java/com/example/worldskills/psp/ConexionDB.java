package com.example.worldskills.psp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.PortUnreachableException;

public class ConexionDB extends SQLiteOpenHelper {

    public ConexionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Proyectos(indiceProyecto AUTO_INCREMENT, nombreProyecto TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Metodo para agregar Proyecto a La lista de Inicio
     * @param db
     * @param nombre
     */
    public void agregarProyecto(SQLiteDatabase db, String nombre){
        db.execSQL("INSERT INTO Proyectos (nombreProyecto) VALUES ('" + nombre +"')");
    }
}
