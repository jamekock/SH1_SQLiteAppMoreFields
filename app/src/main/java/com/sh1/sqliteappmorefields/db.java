package com.sh1.sqliteappmorefields;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class db extends SQLiteOpenHelper {
    public db(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//campos nombre, apellido, codigo_empleado, cedula, departamento, dirección, sueldo.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE personas(id INTEGER PRIMARY KEY, nombre TEXT, apellido TEXT, codigo_empleado TEXT, cedula TEXT, departamento TEXT, direccion TEXT ,sueldo TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
