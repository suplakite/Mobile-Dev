package com.example.myapplication;

public class Circle extends Figures {

    public Circle(float linearDimension, String name) {
        this.setLinearDimension(linearDimension);
        this.setName(name);
        this.field = this.field();
    }

    public double getDiameter() {
        return this.roundTo3DecimalPlaces(2 * this.getLinearDimension());
    }

    @Override
    public double field() {
        return this.roundTo3DecimalPlaces(3.14 * this.getLinearDimension() * this.getLinearDimension());
    }

    @Override
    public double getDimension() {
        return this.getDiameter();
    }

    @Override
    public String dimension() {
        return ("Diameter\n" + this.getDiameter());
    }

    @Override
    public int getImage() {
        return R.drawable.circle;
    }

}
