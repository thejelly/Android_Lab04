package com.example.lab04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class lab04_01 extends AppCompatActivity {
    ArrayList<String> selected = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab04_01);
        ListView listView = findViewById(R.id.listview);
        String []menu_name = {"汉堡","薯条","可乐","玉米浓汤"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,menu_name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (selected.contains(menu_name[position])){
                    selected.remove(menu_name[position]);
                }
                else {
                    selected.add(menu_name[position]);
                }
                String str = "你点了 ："+String.join(" ",selected);
                EditText editText   = findViewById(R.id.editTextText);
                editText.setText(str);
            }
        });
    }
}
