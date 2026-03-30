package com.example.lab04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class lab05_02 extends AppCompatActivity {
    int num=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab05_02);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(String.valueOf(num));
        Button bn = findViewById(R.id.button2);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                textView.setText(String.valueOf(num));
            }
        });
        bn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                num+=5;
                textView.setText(String.valueOf(num));
                return true;
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                num=0;
                textView.setText(String.valueOf(num));
                return true;
            }
        });
    }
}
