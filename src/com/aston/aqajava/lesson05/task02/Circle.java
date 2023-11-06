package com.aston.aqajava.lesson05.task02;


import java.util.Objects;

public class Circle extends Figure{
    private double radius;
    private String fillColor; // can be changed after creation
    private String borderColor; // can be changed after creation
    public Circle(double radius){
        this.radius = radius;
        this.fillColor = "green";
        this.borderColor = "green";
    }
    public Circle(double radius, String fillColor, String borderColor){
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        double perimeter = 2 * Math.PI * getRadius();
        return perimeter;
    }

    @Override
    public double square() {
        double square = Math.PI * Math.pow(getRadius(),2);
        return square;
    }

    @Override
    public void figureColor() {
        System.out.println("Fill color = " + getFillColor() + "\nBorder Color = " + getBorderColor());
    }

    public double getRadius() {
        return radius;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(fillColor, circle.fillColor) && Objects.equals(borderColor, circle.borderColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, fillColor, borderColor);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", fillColor='" + fillColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                '}';
    }
}
