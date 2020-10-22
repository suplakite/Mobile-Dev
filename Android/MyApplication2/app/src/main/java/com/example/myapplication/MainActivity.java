package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    float[] fields = new float[9];
    private int min = 0;
    private int max = 0;
    private int num = 0;

    private ArrayList<Figures> figures;

    private void insertFigures(int orderBy) {
        LinearLayout linearLayout = findViewById(R.id.layout);

        if (orderBy == 1) {
            this.figures.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        } else if (orderBy == 2) {
            System.out.println(figures);
            Collections.sort(figures, new Comparator<Figures>() {
                @Override
                public int compare(Figures o1, Figures o2) {
                    return Double.compare(o1.getField(), o2.getField() );
                }
            });
            System.out.println(figures);
        } else if (orderBy == 3) {
            Collections.sort(figures, new Comparator<Figures>() {
                @Override
                public int compare(Figures o1, Figures o2) {
                    return Double.compare(o1.getDimension(), o2.getDimension());
                }
            });
        }


        figures.forEach(figure -> {
            if (figure.getName().equals("Triangle")) {
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
            System.out.println(figure.getField());
            View oneRow = getLayoutInflater().inflate(R.layout.tricot, null);
            ImageView image = oneRow.findViewById(R.id.figureImage);
            TextView text1 = oneRow.findViewById(R.id.textView2);
            TextView text2 = oneRow.findViewById(R.id.textView3);
            image.setImageResource(figure.getImage());
            text1.setText(Double.toString(figure.getField()));
            text2.setText(figure.dimension());
            linearLayout.addView(oneRow);
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.min = Integer.parseInt(extras.getString("min"));
            this.max = Integer.parseInt(extras.getString("max"));
            this.num = Integer.parseInt(extras.getString("num"));
        }

        this.figures = Program.main(this.min, this.max, this.num);

        for (int i = 0; i < this.fields.length; i++) {
            this.fields[i] = 0;
        }
        insertFigures(0);

    }

    public void runActivity(View view) {
        Intent intent = null;
        int requestCode = 1;
        switch (view.getId()) {

            case R.id.btn_stats:
                intent = new Intent(this, Stats.class);
                requestCode = 1;
                String value = "Hello world";
                intent.putExtra("triangle_field", this.fields[0]);
                intent.putExtra("square_field", this.fields[1]);
                intent.putExtra("circle_field", this.fields[2]);
                intent.putExtra("triangle_numbers", this.fields[3]);
                intent.putExtra("square_numbers", this.fields[4]);
                intent.putExtra("circle_numbers", this.fields[5]);
                intent.putExtra("triangle_triats", this.fields[6]);
                intent.putExtra("square_triats", this.fields[7]);
                intent.putExtra("circle_triats", this.fields[8]);
                startActivityForResult(intent, requestCode);
                break;
            case R.id.btn_settings1:
                intent = new Intent(this, Settings.class);
                requestCode = 2;
                System.out.println(this.min);
                intent.putExtra("min", this.min);
                intent.putExtra("max", this.max);
                intent.putExtra("num", this.num);
                startActivityForResult(intent, requestCode);
                break;
            case R.id.orderby_figures:
                LinearLayout lay = findViewById(R.id.layout);
                lay.removeAllViews();
                this.insertFigures(1);
                break;
            case R.id.orderby_fields:
                LinearLayout lay1 = findViewById(R.id.layout);
                lay1.removeAllViews();
                this.insertFigures(2);
                break;
            case R.id.orderby_triats:
                LinearLayout lay2 = findViewById(R.id.layout);
                lay2.removeAllViews();
                this.insertFigures(3);
                break;
        }

    }
}




