package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                TextView triangle_fields = findViewById(R.id.triangle_fields);
                triangle_fields.setText(Float.toString(extras.getFloat("triangle_field")));
                TextView triangle_numbers = findViewById(R.id.triangle_numbers);
                triangle_numbers.setText(Float.toString(extras.getFloat("triangle_numbers")));
                TextView triangle_triats = findViewById(R.id.triangle_triats);
                triangle_triats.setText(Float.toString(extras.getFloat("triangle_triats")));

                TextView circle_fields = findViewById(R.id.circle_fields);
                circle_fields.setText(Float.toString(extras.getFloat("circle_field")));
                TextView circle_numbers = findViewById(R.id.circle_numbers);
                circle_numbers.setText(Float.toString(extras.getFloat("circle_numbers")));
                TextView circle_triats = findViewById(R.id.circle_triats);
                circle_triats.setText(Float.toString(extras.getFloat("circle_triats")));

                TextView square_fields = findViewById(R.id.square_fields);
                square_fields.setText(Float.toString(extras.getFloat("square_field")));
                TextView square_numbers = findViewById(R.id.square_numbers);
                square_numbers.setText(Float.toString(extras.getFloat("square_numbers")));
                TextView square_triats = findViewById(R.id.square_triats);
                square_triats.setText(Float.toString(extras.getFloat("square_triats")));
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            //The key argument here must match that used in the other activity
        }

    }

    public void runActivity(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                finish();
                break;
        }

    }

}