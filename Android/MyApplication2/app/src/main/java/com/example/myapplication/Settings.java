package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    public int max, min, num;

    public int get_max() {
        return max;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
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
                EditText max_dimension = findViewById(R.id.max_dimension);
                max_dimension.setText(Integer.toString(this.max));
            }
            if (this.getMin() != 0) {
                EditText min_dimension = findViewById(R.id.min_dimension);
                min_dimension.setText(Integer.toString(this.min));
            }
            if (this.getNum() != 0) {
                EditText num_of_elems = findViewById(R.id.num_of_elems);
                num_of_elems.setText(Integer.toString(this.num));
            }
        }
    }

    public void runActivity(View view) {
        Intent intent = null;
        int requestCode = 1;
        switch (view.getId()) {
            case R.id.btn_submit:
                System.out.println("Submit");
                intent = new Intent(this, MainActivity.class);
                EditText min_dimension = findViewById(R.id.min_dimension);
                String mina = min_dimension.getText().toString();
                EditText max_dimension = findViewById(R.id.max_dimension);
                String maxa = max_dimension.getText().toString();
                EditText num_of_elems = findViewById(R.id.num_of_elems);
                String numa = num_of_elems.getText().toString();

                System.out.println("LENGTH");
                System.out.println(mina.length());
                System.out.println(get_max());

                boolean greater = true;

                try{
                    if (Integer.parseInt(mina) >= Integer.parseInt(maxa)) {
                        Toast.makeText(this, "MIN > MAX !!!!", Toast.LENGTH_SHORT).show();
                        greater = false;
                    } else if (Integer.parseInt(mina) >= Integer.parseInt(maxa)){
                        Toast.makeText(this, "MIN = MAX !!!!", Toast.LENGTH_SHORT).show();
                        greater = false;
                    }

                } catch (Exception e) {
                    System.out.println();
                }


                if (mina.matches("") || maxa.matches("")) {
                    intent.putExtra("min", Integer.toString(0));
                    intent.putExtra("max", Integer.toString(0));
                } else {
                    intent.putExtra("min", mina);
                    intent.putExtra("max", maxa);
                }

                if (numa.matches("")) {
                    intent.putExtra("num", Integer.toString(0));
                } else {
                    intent.putExtra("num", numa);
                }
                try {
                    System.out.println("Tomek");
                    System.out.println(max == Integer.parseInt(maxa));
                    System.out.println(min == Integer.parseInt(mina));
                    System.out.println(num == Integer.parseInt(numa));
                    if(this.getMax() == Integer.parseInt(maxa) && this.getMin() == Integer.parseInt(mina) && this.getNum() == Integer.parseInt(numa)){
                        finish();
                        break;
                    }
                } catch (Exception e){
                    System.out.println();
                }

                if (greater){
                    requestCode = 1;
                    startActivityForResult(intent, requestCode);
                }



                break;
        }
    }
}