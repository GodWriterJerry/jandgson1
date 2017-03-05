package com.example.administrator.jandgson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Button mButton1;
    private TextView mTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1= (Button) findViewById(R.id.btn_1);
        mTextView1= (TextView) findViewById(R.id.tx_1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequestWithOkHttp();
            }
        });
    }

    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://192.168.137.1:8080/ShoppingCart/json.jsp")
                            .build();
                    Response response = okHttpClient.newCall(request).execute();
                    final String data = response.body().string();
                    parseJsonWithGson(data);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextView1.setText(data);
                        }
                    });
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJsonWithGson(String data) {
        Gson gson=new Gson();
        Student student=gson.fromJson(data,Student.class);
        for (int i = 0; i < student.getStu().size(); i++) {
            Log.i("Student", String.valueOf(student.getStu().get(i).getId()));
            Log.i("Student", String.valueOf(student.getStu().get(i).getAge()));
            Log.i("Student", student.getStu().get(i).getName());
        }
    }
}
