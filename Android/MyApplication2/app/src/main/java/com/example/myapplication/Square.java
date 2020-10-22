package com.example.myapplication;

public class Square extends Figures {
    Square(float linearDimension, String name) {
        this.setLinearDimension(linearDimension);
        this.setName(name);
        this.field = this.field();
    }

    public double getDiagonal() {
        return this.roundTo3DecimalPlaces(this.getLinearDimension() * Math.sqrt(2));
    }

    @Override
    public double field() {
        return this.roundTo3DecimalPlaces(this.getLinearDimension() * this.getLinearDimension());
    }

    @Override
    public double getDimension() {
        return this.getDiagonal();
    }

    @Override
    public String dimension() {
        return ("Diagonal\n" + this.getDiagonal());
    }

    @Override
    public int getImage() {
        return R.drawable.square;
    }
}
