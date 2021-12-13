package gr.hua.dit.android.sqliteapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper  extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, DbContract.DB_NAME, null, DbContract.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(DbContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
