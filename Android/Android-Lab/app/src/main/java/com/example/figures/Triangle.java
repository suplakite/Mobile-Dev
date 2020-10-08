package com.example.figures;

import com.example.figures.Figures;

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
        return ("Height - " + this.roundTo3DecimalPlaces(this.getHeight()));
    }
}
