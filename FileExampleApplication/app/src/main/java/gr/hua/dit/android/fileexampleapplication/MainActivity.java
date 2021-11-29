package gr.hua.dit.android.fileexampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    //close and reopen app. Written text will appear on TextView field!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.closeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity:onPause", "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity:onDestroy", "onDestroy: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity:onStop", "onStop: ");

        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString();
        try {
            FileOutputStream stream = openFileOutput("test.txt", this.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.write(text);
            writer.close();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity:onResume", "onResume: ");

        try {
            FileInputStream stream = openFileInput("test.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String text = reader.readLine();
            TextView textView = findViewById(R.id.textView);
            textView.setText(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}