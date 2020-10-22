package com.example.myapplication;

import com.example.myapplication.Figures;

public class Triangle extends Figures {

    private float height;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Triangle(float linearDimension, float height, String name) {
        this.setLinearDimension(linearDimension);
        this.setHeight(height);
        this.setName(name);
    }

    @Override
    public double field() {
        return this.roundTo3DecimalPlaces(this.getHeight() * this.getLinearDimension() / 2);
    }

    @Override
    public String dimension() {
        return ("Height\n" + this.roundTo3DecimalPlaces(this.getHeight()));
    }
    @Override
    public int getImage(){
        return R.drawable.triangle;
    }
}
