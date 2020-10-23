package com.example.pum_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class Gauss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauss);

        int real = 0;
        int imaginary = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            real = extras.getInt("real");
            imaginary = extras.getInt("imag");
        }

        GraphView graph = (GraphView) findViewById(R.id.graph);
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(real, imaginary),
        });

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(real - 10);
        graph.getViewport().setMaxX(real + 10);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(imaginary - 10);
        graph.getViewport().setMaxY(imaginary + 10);

        graph.addSeries(series);
        series.setShape(PointsGraphSeries.Shape.POINT);
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
