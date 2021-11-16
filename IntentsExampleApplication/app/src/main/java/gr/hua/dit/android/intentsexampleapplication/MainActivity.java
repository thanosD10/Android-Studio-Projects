package gr.hua.dit.android.intentsexampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.firstButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, SecondActivity.class);
            intent.setAction("gr.hua.dit.android.intentsexampleapplication.myaction"); //implicit rooting
            startActivity(intent);
            finish();
        });
    }
}