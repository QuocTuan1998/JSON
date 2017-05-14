package com.example.quoctuan.json.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.quoctuan.json.R;

public class MainActivity extends AppCompatActivity {

    static final String URL_LIST_USERS = "https://jsonplaceholder.typicode.com/users";
    static final String URI_PHOTOS = "https://jsonplaceholder.typicode.com/photos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
