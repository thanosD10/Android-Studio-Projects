package gr.hua.dit.android.threadapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textview);
        final Button button = findViewById(R.id.button);


//        //ACTIVITY.RUNONUITHREAD(RUNNABLE)
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Thread t = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                textView.setText("Blah blah");
//                            }
//                        });
//                    }
//                });
//                t.start();
//            }
//        });


//        //VIEW.POST(RUNNABLE)
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("Blah blah");
//                    }
//                });
//            }
//        });

        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL url = new URL("https://www.google.com");
                            URLConnection connection = url.openConnection();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            Log.d("READER", reader.readLine());
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });


    }
}