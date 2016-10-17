package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by nicolaslacaze on 15/09/16.
 */
public class  PetDbHelper extends SQLiteOpenHelper {

    //DatabaSse version
    public static final int DB_VERSION = 1;

    //Constant database name
    public static final String DB_NAME = "pets.db";

    public PetDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PET_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + "("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL,"
                + PetEntry.COLUMN_PET_BREED + " TEXT,"
                + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL,"
                + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0" + ");";
        db.execSQL(CREATE_PET_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME);

        //Creates table again
        onCreate(db);
    }
}
