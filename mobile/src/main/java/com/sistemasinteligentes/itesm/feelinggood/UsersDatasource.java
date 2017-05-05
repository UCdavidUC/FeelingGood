package com.sistemasinteligentes.itesm.feelinggood;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.SQLException;
import android.database.Cursor;

/**
 * Created by David Sánchez Almanza on 4/30/2017.
 */

public class UsersDatasource {

    private SQLiteDatabase database;
    private DatabaseManager db_manager;

    private String[] columns = {
            DatabaseManager.COLUMN_EMAIL,
            DatabaseManager.COLUMN_CONTRASENA,
            DatabaseManager.COLUMN_PESO,
            DatabaseManager.COLUMN_ESTATURA,
            DatabaseManager.COLUMN_FECHA_NAC
    };

    public UsersDatasource(Context context) {
        db_manager = new DatabaseManager(context);
        System.out.println("Creating database...");
    }

    public void open() throws SQLException {
        database = db_manager.getWritableDatabase();
        System.out.println("Opening database...");
    }

    public void close() {
        db_manager.close();
        System.out.println("Closing database...");
    }

    public User createUser(String email, String contrasena, float peso, float estatura, String fecha_nac) {
        ContentValues values = new ContentValues();
        values.put(DatabaseManager.COLUMN_EMAIL, email);
        values.put(DatabaseManager.COLUMN_CONTRASENA, contrasena);
        values.put(DatabaseManager.COLUMN_PESO, peso);
        values.put(DatabaseManager.COLUMN_ESTATURA, estatura);
        values.put(DatabaseManager.COLUMN_FECHA_NAC, fecha_nac);

        long insertId = database.insert(DatabaseManager.TABLE_USERS, null, values);
        Cursor cursor = database.query(DatabaseManager.TABLE_USERS, columns, DatabaseManager.COLUMN_EMAIL + "='" + email + "'", null, null, null, null);
        cursor.moveToFirst();

        User user = cursorToUser(cursor);
        cursor.close();
        return user;
    }

    private User cursorToUser(Cursor cursor) {
        User user = new User();
        user.setEmail(cursor.getString(0));
        user.setContrasena(cursor.getString(1));
        user.setPeso(cursor.getFloat(2));
        user.setEstatura(cursor.getFloat(3));
        user.setFecha_nac(cursor.getString(4));
        return user;
    }

}
