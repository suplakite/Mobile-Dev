package com.example.myapplication;

public abstract class Figures {

    private float linearDimension;
    private String name;
    public float getLinearDimension() {
        return linearDimension;
    }

    public void setLinearDimension(float linearDimension) {
        this.linearDimension = linearDimension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double roundTo3DecimalPlaces(float numb){
        return Math.round(numb * 1000.0) / 1000.0;
    }

    public double roundTo3DecimalPlaces(double numb){
        return Math.round(numb * 1000.0) / 1000.0;
    }



    public abstract String dimension();
    public abstract double field();
    public abstract int getImage();

}
