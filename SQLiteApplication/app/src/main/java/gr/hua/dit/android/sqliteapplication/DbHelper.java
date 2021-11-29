package gr.hua.dit.android.sqliteapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper  extends SQLiteOpenHelper {
    static public String DB_NAME = "CONTACTS_DB";
    static public int DB_VERSION = 1;
    static public String TABLE_NAME = "CONTACTS";
    static public String FIELD_1 = "NAME";
    static public String FIELD_2 = "PHONE_NUMBER";


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE "+TABLE_NAME+" ('"+FIELD_1+"' TEXT, '"+FIELD_2+"' TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
