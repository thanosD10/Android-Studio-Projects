package gr.hua.dit.android.handlertestapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    final int SHOW_PROGRESS_BAR = -1;
    final int DISABLE_PROGRESS_BAR = -2;
    Handler workerHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonOne);
        Button buttonTwo = findViewById(R.id.buttonTwo);
        EditText editText = findViewById(R.id.editText);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(20);
        progressBar.setVisibility(View.INVISIBLE);
        Handler mainHandler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case SHOW_PROGRESS_BAR:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case DISABLE_PROGRESS_BAR:
                        progressBar.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        };
        button.setOnClickListener((v)->{
            new Thread(()->{
                mainHandler.sendEmptyMessage(SHOW_PROGRESS_BAR);
                for(int i=1;i<=20;i++) {
                    try {
                        Thread.sleep(1000);
                        int finalI = i;
                        mainHandler.post(()->{
                            progressBar.setProgress(finalI);
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mainHandler.sendEmptyMessage(DISABLE_PROGRESS_BAR);
            }).start();
        });

        new Thread(()->{
            Looper.prepare();
            workerHandler = new Handler(Looper.myLooper()){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    Log.d("WorkerThreadHandler", msg.what + "");
                }
            };
            Looper.loop();
        }).start();

        buttonTwo.setOnClickListener((v)->{
            String text = editText.getText().toString();
            workerHandler.sendEmptyMessage(Integer.parseInt(text));
        });
    }
}