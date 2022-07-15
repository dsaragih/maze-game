package com.mygdx.game.geometry;

public class Circle {
    public Point center;
    public float radius;

    public Circle(Point center, float radius){
        this.center = center;
        this.radius = radius;
    }

    public boolean intersects(Circle other){
        Point dist = center.separation(other.center);
        return dist.length() <= radius + other.radius;
    }
}
