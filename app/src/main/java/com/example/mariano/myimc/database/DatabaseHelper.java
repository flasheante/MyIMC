package com.example.mariano.myimc.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mariano.myimc.IMC.IMC;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
    private static final String DB_NAME = "com.example.mariano.DB_BASE";
    public static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, IMC.class);
        } catch (SQLException e) {
            // Do nothing
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        // Up... What?
    }
}
