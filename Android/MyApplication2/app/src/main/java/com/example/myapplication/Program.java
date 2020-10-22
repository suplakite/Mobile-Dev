package com.example.myapplication;
import com.example.myapplication.Figures;
import java.util.*;

public class Program {

    public static Figures[] main(float min, float max, int tableSize) {
        Random generator = new Random();
        if (min == 0){
            min = 1;
        }
        if (max == 0){
            max = 4;
        }
        if(tableSize == 0) {
            tableSize = 100;
        }
        Figures[] figures = new Figures[tableSize];

        for(int i=0; i<tableSize; i+=1) {
            int type = generator.nextInt(3);
            switch (type){
                case 0: {
                    Triangle triangle = new Triangle(
                            min + generator.nextFloat() * (max - min),
                            (min + generator.nextFloat() * (max - min)), "Triangle");
                    figures[i] = triangle;
                    break;
                }
                case 1: {
                    Circle circle = new Circle(min + generator.nextFloat() * (max - min), "Circle");
                    figures[i] = circle;
                    break;
                }
                case 2: {
                    Square square = new Square(min + generator.nextFloat() * (max - min), "Square");
                    figures[i] = square;
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