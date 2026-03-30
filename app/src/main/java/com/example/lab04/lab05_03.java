package com.example.lab04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;
public class lab05_03 extends AppCompatActivity {
    private ImageView image;
    int imgids[] = new int[]{
            R.drawable.s1, R.drawable.s2,R.drawable.s3};
    int imgstart = 0;
    Handler myHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            //补充程序

            if (msg.what == 1) {
                image.setImageResource(imgids[imgstart]);
                imgstart = (imgstart + 1) % imgids.length;
            }
            return true;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab05_03);
        image = findViewById(R.id.imageView2);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //补充程序
                Message msg = new Message();
                msg.what = 1;
                myHandler.sendMessage(msg);

            }
        }, 0,1000);
    }
}
