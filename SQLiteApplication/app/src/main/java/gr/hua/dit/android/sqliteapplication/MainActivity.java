package gr.hua.dit.android.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(MainActivity.this);

        findViewById(R.id.insert_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameET = findViewById(R.id.name);
                EditText phoneET = findViewById(R.id.phone_number);
                String name = nameET.getText().toString();
                String phone = phoneET.getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DbHelper.FIELD_1,name);
                values.put(DbHelper.FIELD_2,phone);
                long result = db.insert(DbHelper.TABLE_NAME,null,values);
                Toast.makeText(MainActivity.this,result+"",Toast.LENGTH_SHORT).show();
                db.close();
            }
        });

        findViewById(R.id.select_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor results = db.query(DbHelper.TABLE_NAME,
                        new String[]{"ROWID", DbHelper.FIELD_1},
                        DbHelper.FIELD_2+"=?",
                        new String[]{"1234"},
                        null,
                        null,
                        null
                );
                if(results.moveToFirst()) {
                    do {
                        Toast.makeText(MainActivity.this, ""+results.getString(0), Toast.LENGTH_SHORT).show();
                    } while(results.moveToNext());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}