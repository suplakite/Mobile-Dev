package com.example.pum_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int real_result;
    int imaginary_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.choices,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void Result(int operation) {
        EditText real_one = findViewById(R.id.real_one);
        String real1= real_one.getText().toString();
        EditText real_two = findViewById(R.id.real_two);
        String real2 = real_two.getText().toString();
        EditText imaginary_one = findViewById(R.id.imaginary_one);
        String imaginary1 = imaginary_one.getText().toString();
        EditText imaginary_two = findViewById(R.id.imaginary_two);
        String imaginary2 = imaginary_two.getText().toString();

        if(!real1.isEmpty() && !real2.isEmpty() && !imaginary1.isEmpty() && !imaginary2.isEmpty()) {

            int _real1 = Integer.parseInt(real1);
            int _real2 = Integer.parseInt(real2);
            int _imaginary1 = Integer.parseInt(imaginary1);
            int _imaginary2 = Integer.parseInt(imaginary2);

            if (operation == 1){
                real_result = _real1 + _real2;
                imaginary_result = _imaginary1 + _imaginary2;
            } else {

                real_result = _real1 - _real2;
                imaginary_result = _imaginary1 - _imaginary2;
            }
            String sign;

            if (imaginary_result > 0) {
                sign = " + ";
            } else {
                sign = " ";
            }

            TextView text_result = (TextView) findViewById(R.id.result_text);
            text_result.setText(Integer.toString(real_result) + sign + Integer.toString(imaginary_result) + "i");
        }
    }


    public void runActivity(View view) {
        Intent intent = null;
        int requestCode = 1;
        switch (view.getId()) {

            case R.id.btn_add:
                Result(1);
                break;
            case R.id.btn_sub:
                Result(0);
                break;
            case R.id.btn_gauss:
                intent = new Intent(this, Gauss.class);

                intent.putExtra("imag", this.imaginary_result);
                intent.putExtra("real", this.real_result);
                startActivityForResult(intent, requestCode);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        System.out.println(text);
        if (text.equals("Sub")) {
            Result(0);
        } else if (text.equals("Add")) {
            Result(1);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}