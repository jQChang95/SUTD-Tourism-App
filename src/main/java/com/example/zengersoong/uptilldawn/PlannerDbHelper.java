package com.example.zengersoong.uptilldawn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jun Qing on 11/28/2017.
 */

public class PlannerDbHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    PlannerDbHelper(Context context){
        super(context, AttractionsContract.AttractionsEntry.TABLE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " + AttractionsContract.AttractionsEntry.TABLE_NAME + "(" + AttractionsContract.AttractionsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AttractionsContract.AttractionsEntry.COL_LOCATION + " TEXT NOT NULL " + ")";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        final String SQL_DELETE_TABLE = "DROP TABLE IF EXIST " + AttractionsContract.AttractionsEntry.TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);

    }
}
