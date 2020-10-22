package com.example.lab2;

public class Square extends Figures{
    Square(float linearDimension, String name){
        this.setLinearDimension(linearDimension);
        this.setName(name);
    }

    public double getDiagonal() {
        return this.roundTo3DecimalPlaces(this.getLinearDimension() * Math.sqrt(2));
    }

    @Override
    public double field() {
        return this.roundTo3DecimalPlaces(this.getLinearDimension() * this.getLinearDimension());
    }

    @Override
    public String dimension() {
        return ("Diagonal\n" + this.getDiagonal());
    }
}
