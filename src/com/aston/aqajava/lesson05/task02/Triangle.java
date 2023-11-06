package com.aston.aqajava.lesson05.task02;

import java.util.Objects;

public class Triangle extends Figure{
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor; // can be changed after creation
    private String borderColor; // can be changed after creation

    public Triangle(double sideA, double sideB, double sideC){
        if ((sideA + sideB <= sideC) || (sideA + sideC) <= sideB || (sideB + sideC) <= sideA){
            throw new RuntimeException("Incorrect input. Such triangle does not exist.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = "blue";
        this.borderColor = "blue";
    }
    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor){
        if ((sideA + sideB <= sideC) || (sideA + sideC) <= sideB || (sideB + sideC) <= sideA){
            throw new RuntimeException("Incorrect input. Such triangle does not exist.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double perimeter() {
        double perimeter = getSideA()+getSideB()+getSideC();
        return perimeter;
    }

    @Override
    public double square() {
        double halfPerimeter = perimeter();
        double square = Math.sqrt(halfPerimeter * ( halfPerimeter - getSideA()) *
                (halfPerimeter - getSideB()) * (halfPerimeter - getSideC()));
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

    public double getSideC() {
        return sideC;
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
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.sideA, sideA) == 0 && Double.compare(triangle.sideB, sideB) == 0 && Double.compare(triangle.sideC, sideC) == 0 && Objects.equals(fillColor, triangle.fillColor) && Objects.equals(borderColor, triangle.borderColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC, fillColor, borderColor);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", fillColor='" + fillColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                '}';
    }
}
