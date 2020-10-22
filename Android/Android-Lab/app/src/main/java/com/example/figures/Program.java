package com.example.figures;
import com.example.figures.Figures;
import java.util.*;

public class Program {

    public static Figures[] main() {
        Random generator = new Random();

        int tableSize = 10;
        Figures[] figures = new Figures[tableSize];

        for(int i=0; i<tableSize; i+=1) {
            int type = generator.nextInt(3);
            switch (type){
                case 0: {
                    Triangle triangle = new Triangle(generator.nextFloat(), generator.nextFloat(), "Triangle");
                    figures[i] = triangle;
                    break;
                }
                case 1: {
                    Circle circle = new Circle(generator.nextFloat(), "Circle");
                    figures[i] = circle;
                    break;
                }
                case 2: {
                    Square square = new Square(generator.nextFloat(), "Square");
                    figures[i] = square;
                    break;
                }
            }
        }
        for(int i=0; i<tableSize; i+=1) {
            System.out.println(figures[i].getName() + ": Field - " + figures[i].field() + " " + figures[i].dimension());
        }

        return figures;
    }
}
