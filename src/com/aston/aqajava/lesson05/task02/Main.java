package com.aston.aqajava.lesson05.task02;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2,2,2);
        Rectangle rectangle = new Rectangle(2,3);
        Circle circle = new Circle(5);

        System.out.println("Triangle parameters: ");
        figureInfo(triangle);
        System.out.println("--------------");
        System.out.println("Rectangle parameters: ");
        figureInfo(rectangle);
        System.out.println("--------------");
        System.out.println("Circle parameters: ");
        figureInfo(circle);
        System.out.println("--------------");

    }
    public static void figureInfo(Figure a){
        System.out.println("\nPerimeter = " + a.perimeter() +
                "\nSquare = " + a.square());
        a.figureColor();
    }
}
