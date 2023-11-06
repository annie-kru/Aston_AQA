package com.aston.aqajava.lesson05.task02;

import java.util.Objects;

public class Rectangle extends Figure{
    private double sideA;
    private double sideB;
    private String fillColor; // can be changed after creation
    private String borderColor; // can be changed after creation
    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
        this.fillColor = "red";
        this.borderColor = "red";
    }
    public Rectangle(double sideA, double sideB, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        double perimeter = getSideA() + getSideB();
        return perimeter;
    }

    @Override
    public double square() {
        double square = getSideA() * getSideB();
        return square;
    }
    @Override
    public void figureColor() {
        System.out.println("Fill color = " + getFillColor() + "\nBorder Color = " + getBorderColor());
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
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
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.sideA, sideA) == 0 && Double.compare(rectangle.sideB, sideB) == 0 && Objects.equals(fillColor, rectangle.fillColor) && Objects.equals(borderColor, rectangle.borderColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, fillColor, borderColor);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", fillColor='" + fillColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                '}';
    }
}
