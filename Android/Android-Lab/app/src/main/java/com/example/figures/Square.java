package com.example.figures;

import com.example.figures.Figures;

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
        return ("Diagonal - " + this.getDiagonal());
    }
}
