package com.sistemasinteligentes.itesm.feelinggood;

import android.content.ContentValues;
import android.provider.BaseColumns;
import android.content.Context;
import android.database.sqlite.*;
import android.util.Log;

import java.security.PrivateKey;

/**
 * Created by t-dasalm on 4/20/2017.
 */


public class DatabaseManager extends SQLiteOpenHelper {

    // Databse constants
    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;

    // Column names for USERS table
    public static final String TABLE_USERS = "usuarios";
    public static final String COLUMN_EMAIL = "_id";
    public static final String COLUMN_CONTRASENA = "contrasena";
    public static final String COLUMN_PESO = "peso";
    public static final String COLUMN_ESTATURA = "estatura";
    public static final String COLUMN_FECHA_NAC = "fecha_nac";

    // Column names for MEALS table
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_HINICIO = "hora_inicio";

    // Database create query
    private static final String DATABASE_USERS = "CREATE TABLE " + TABLE_USERS + " (" +
            COLUMN_EMAIL + " text not null primary key unique, " +
            COLUMN_CONTRASENA + " text not null, " +
            COLUMN_PESO + " number no null, " +
            COLUMN_ESTATURA + " number no null, " +
            COLUMN_FECHA_NAC + " text no null);";

    private static final String DATABASE_MEALS = "CREATE TABLE " + TABLE_USERS + " (" +
            COLUMN_ID + " number autoincrement primary key unique, " +
            COLUMN_NOMBRE + " text not null, " +
            COLUMN_HINICIO + " number not null); ";


    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_USERS);
        //database.execSQL(DATABASE_MEALS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(DatabaseManager.class.getName(),
                "Upgradind database from version " + oldVersion +
                " to version " + newVersion + " this upgrade will delete all data stored.");
        database.execSQL("DROP TABLE IF EXISTS users;");
        onCreate(database);
    }
}
