package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    float [] fields = new float[9];
    private int min = 0;
    private int max = 0;
    private int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
//            if (extras.getString("min") != null) {
            this.min = Integer.parseInt(extras.getString("min"));
//            }
//            if (extras.getString("max") != null) {
            this.max = Integer.parseInt(extras.getString("max"));
//            }
//            if (extras.getString("num") != null) {
            this.num = Integer.parseInt(extras.getString("num"));
//            }
        }

        System.out.println("-------------");
        System.out.println(this.min);
        System.out.println(this.max);
        System.out.println(this.num);
        System.out.println("-------------");

        Figures[] figures = Program.main(this.min,this.max,this.num);

        for(int i=0; i<this.fields.length; i++) {
            this.fields[i] = 0;
        }

        for(int i=0; i<figures.length; i++){

            Figures figure = figures[i] ;

            if (figure.getName().equals("Triangle")){
                this.fields[0] += figure.field();
                this.fields[3] += 1;
                this.fields[6] += figure.getLinearDimension();
            } else if (figure.getName().equals("Circle")) {
                this.fields[2] += figure.field();
                this.fields[5] += 1;
                this.fields[8] += figure.getLinearDimension();
            } else if (figure.getName().equals("Square")) {
                this.fields[1] += figure.field();
                this.fields[4] += 1;
                this.fields[7] += figure.getLinearDimension();
            }

            View oneRow = getLayoutInflater().inflate(R.layout.tricot, null);
            ImageView image = (ImageView) oneRow.findViewById(R.id.figureImage);
            TextView text1 = (TextView) oneRow.findViewById(R.id.textView2);
            TextView text2 = (TextView) oneRow.findViewById(R.id.textView3);
            image.setImageResource(figure.getImage());
            text1.setText(Double.toString(figure.field()));
            text2.setText(figure.dimension());
            linearLayout.addView(oneRow);
        }
    }

    public void runActivity(View view){
        Intent intent=null;
        int requestCode=1;
        switch(view.getId()){
            case R.id.btn_stats:
                System.out.println("Stats");
                intent = new Intent(this,Stats.class);
                requestCode=1;
                String value="Hello world";
                intent.putExtra("triangle_field", this.fields[0]);
                intent.putExtra("square_field", this.fields[1]);
                intent.putExtra("circle_field", this.fields[2]);
                intent.putExtra("triangle_numbers", this.fields[3]);
                intent.putExtra("square_numbers", this.fields[4]);
                intent.putExtra("circle_numbers", this.fields[5]);
                intent.putExtra("triangle_triats", this.fields[6]);
                intent.putExtra("square_triats", this.fields[7]);
                intent.putExtra("circle_triats", this.fields[8]);


                break;
            case R.id.btn_settings1:
                intent = new Intent(this,Settings.class);
                requestCode=2;

                intent.putExtra("min", this.min);
                intent.putExtra("max", this.max);
                intent.putExtra("num", this.num);

                break;
        }
        startActivityForResult(intent,requestCode);
    }

}