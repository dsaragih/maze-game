package com.mygdx.game;

public class Circle {
    public Point center;
    public float radius;

    public Circle(Point center, float radius){
        this.center = center;
        this.radius = radius;
    }

    public boolean intersects(Circle other){
        Point dist = Point.add(center, Point.multiply(other.center, -1));
        return dist.length() <= radius + other.radius;
    }
}
