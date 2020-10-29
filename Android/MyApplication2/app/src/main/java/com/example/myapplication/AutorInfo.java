package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AutorInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor_info);
    }

    public void runActivity(View view) {
        Intent intent = null;
        int requestCode = 1;
        switch (view.getId()) {

            case R.id.button:
                finish();
                break;
        }
    }
}