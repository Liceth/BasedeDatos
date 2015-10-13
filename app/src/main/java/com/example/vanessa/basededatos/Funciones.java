package com.example.vanessa.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by uta on 12/10/2015.
 */
public class Funciones {

    protected SQLiteDatabase db;
    protected UniversityDbHelper dbHelper;

    public void Crear(Context context, String idEstudiante, String nombre, String apellido){
        dbHelper = new UniversityDbHelper(context);
        db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(University.StudentEntry.COLUMN_NAME_ENTRY_ID, idEstudiante);
        content.put(University.StudentEntry.COLUMN_NAME_FIRST_NAME, nombre);
        content.put(University.StudentEntry.COLUMN_NAME_LAST_NAME, apellido);

        db.insert(University.StudentEntry.TABLE_NAME, null, content);
        db.close();
    }

    public void Editar(Context context, String idEstudiante, String nombre, String apellido){
        dbHelper = new UniversityDbHelper(context);
        db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(University.StudentEntry.COLUMN_NAME_FIRST_NAME, nombre);
        content.put(University.StudentEntry.COLUMN_NAME_LAST_NAME, apellido);

        db.update(University.StudentEntry.TABLE_NAME, content, University.StudentEntry.COLUMN_NAME_ENTRY_ID + "=?", new String[]{idEstudiante});
        db.close();
    }


    public void Eliminar(Context context, String idEstudiante){
        dbHelper = new UniversityDbHelper(context);
        db = dbHelper.getWritableDatabase();

        db.delete(University.StudentEntry.TABLE_NAME, University.StudentEntry.COLUMN_NAME_ENTRY_ID + "=?", new String[]{idEstudiante});
        db.close();
    }

    public Cursor Mostrar (Context context){
        dbHelper = new UniversityDbHelper(context);
        db = dbHelper.getWritableDatabase();

        String val [] = {University.StudentEntry.COLUMN_NAME_ENTRY_ID, University.StudentEntry.COLUMN_NAME_FIRST_NAME, University.StudentEntry.COLUMN_NAME_LAST_NAME};
        Cursor c = db.query(University.StudentEntry.TABLE_NAME, val, null, null, null, null, null);

        return c;
    }
}
