package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    public int max, min, num;

    public void setMax(int max) {
        this.max = max;
    }
    public int get_max() {return max;}
    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.setMax(extras.getInt("max"));
            this.setMin(extras.getInt("min"));
            this.setNum(extras.getInt("num"));
            if (this.getMax() != 0) {
                EditText max_dimension = (EditText) findViewById(R.id.max_dimension);
                max_dimension.setText(Integer.toString(this.max));
            }
            if (this.getMin() != 0) {
                EditText min_dimension = (EditText) findViewById(R.id.min_dimension);
                min_dimension.setText(Integer.toString(this.min));
            }
            if (this.getNum() != 0) {
                EditText num_of_elems = (EditText) findViewById(R.id.num_of_elems);
                num_of_elems.setText(Integer.toString(this.num));
            }
        }
    }


    public void runActivity (View view){
        Intent intent = null;
        int requestCode = 1;
        switch (view.getId()) {
            case R.id.btn_submit:
                System.out.println("Submit");
                intent = new Intent(this, MainActivity.class);
                EditText min_dimension = (EditText) findViewById(R.id.min_dimension);
                String mina = (String) min_dimension.getText().toString();
                EditText max_dimension = (EditText) findViewById(R.id.max_dimension);
                String maxa = (String) max_dimension.getText().toString();
                EditText num_of_elems = (EditText) findViewById(R.id.num_of_elems);
                String numa = (String) num_of_elems.getText().toString();

                System.out.println("LENGTH");
                System.out.println(mina.length());
                System.out.println(get_max());

                if (mina.matches("") || maxa.matches("")){
                    intent.putExtra("min", Integer.toString(0));
                    intent.putExtra("max", Integer.toString(0));
                } else {
                    intent.putExtra("min", mina);
                    intent.putExtra("max", maxa);
                }

                if (numa.matches("")){
                    intent.putExtra("num", Integer.toString(0));
                } else {intent.putExtra("num", numa);}



                requestCode = 1;
                break;
        }
        startActivityForResult(intent, requestCode);
    }
}