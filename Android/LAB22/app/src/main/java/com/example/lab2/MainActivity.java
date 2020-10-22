package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.LinearLayout;
import android.widget.RelativeLayout ;
import android.widget.TextView;

import com.example.lab2.Program;
import com.example.lab2.Figures;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout ln = (LinearLayout) findViewById(R.id.linear_inside);
//
        Figures figures[] = Program.main();
//        System.out.println(figures.length);



    }
}