package com.example.myapplication;

import java.util.ArrayList;
import java.util.Random;

public class Program {

    public static ArrayList<Figures> main(float min, float max, int tableSize) {
        Random generator = new Random();
        if (min == 0) {
            min = 1;
        }
        if (max == 0) {
            max = 4;
        }
        if (tableSize == 0) {
            tableSize = 100;
        }
//        Figures[] figures = new Figures[tableSize];

        ArrayList<Figures> figures = new ArrayList<Figures>();

        for (int i = 0; i < tableSize; i += 1) {
            int type = generator.nextInt(3);
            switch (type) {
                case 0: {
                    Triangle triangle = new Triangle(
                            min + generator.nextFloat() * (max - min),
                            (min + generator.nextFloat() * (max - min)), "Triangle");
                    figures.add(triangle);
                    break;
                }
                case 1: {
                    Circle circle = new Circle(min + generator.nextFloat() * (max - min), "Circle");
                    figures.add(circle);
                    break;
                }
                case 2: {
                    Square square = new Square(min + generator.nextFloat() * (max - min), "Square");
                    figures.add(square);
                    break;
                }
            }
        }
//        for(int i=0; i<tableSize; i+=1) {
//            System.out.println(figures[i].getName() + ": Field - " + figures[i].field() + " " + figures[i].dimension());
//        }

        return figures;
    }
}