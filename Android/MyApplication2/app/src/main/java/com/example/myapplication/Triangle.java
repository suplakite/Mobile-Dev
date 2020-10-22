package com.example.myapplication;

public class Triangle extends Figures {

    private float height;

    public Triangle(float linearDimension, float height, String name) {
        this.setLinearDimension(linearDimension);
        this.setHeight(height);
        this.setName(name);
        this.field = this.field();
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public double field() {
        return this.roundTo3DecimalPlaces(this.getHeight() * this.getLinearDimension() / 2);
    }

    @Override
    public double getDimension() {
        return this.getHeight();
    }

    @Override
    public String dimension() {
        return ("Height\n" + this.roundTo3DecimalPlaces(this.getHeight()));
    }

    @Override
    public int getImage() {
        return R.drawable.triangle;
    }
}
