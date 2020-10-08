package com.example.figures;
import com.example.figures.Figures;

public class Circle extends Figures {

    public Circle(float linearDimension, String name){
        this.setLinearDimension(linearDimension);
        this.setName(name);
    }

    public double getDiameter() {
        return this.roundTo3DecimalPlaces(2*this.getLinearDimension());
        }

    @Override
    public double field(){
        return this.roundTo3DecimalPlaces(3.14 * this.getLinearDimension() * this.getLinearDimension());
    }

    @Override
    public String dimension() {
        return ("Diameter - " + this.getDiameter());
    }
}
