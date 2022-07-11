package com.mygdx.game;

public class Point {
    public float x,y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Point p){
        x += p.x;
        y += p.y;
    }

    public void multiply(float scalar){
        x *= scalar;
        y *= scalar;
    }

    public float lengthSquared() {
        return x * x + y * y;
    }
    public float length(){
        return (float) Math.sqrt(lengthSquared());
    }

    public Point normalized(){
        float length = length();
        if(length == 0){
            throw new IllegalArgumentException("Cannot normalize the 0 vector");
        }
        return new Point(x/length, y /length);
    }

    public static Point add(Point p1, Point p2){
        return new Point(p1.x + p2.x, p1.y + p2.y);
    }

    public static Point multiply(Point p1, float scalar){
        return new Point(p1.x * scalar, p1.y * scalar);
    }
}