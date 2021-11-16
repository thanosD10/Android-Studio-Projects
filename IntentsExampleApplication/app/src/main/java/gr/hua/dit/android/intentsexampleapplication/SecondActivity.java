package gr.hua.dit.android.intentsexampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = findViewById(R.id.secondButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}