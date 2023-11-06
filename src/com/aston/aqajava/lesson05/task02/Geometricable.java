package com.aston.aqajava.lesson05.task02;

public interface Geometricable {
    default double perimeter() {
        return 0.0;
    }
    double square();
    void figureColor();
}
