package com.mygdx.game.geometry;

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

    public Point distanceVector(Point p) {
        return new Point(x - p.x, y - p.y);
    }

    public Point normalized(){
        float length = length();
        if(length == 0){
            throw new IllegalArgumentException("Cannot normalize the 0 vector");
        }
        return new Point(x/length, y /length);
    }

    public boolean isZero(){
        return x ==0 && y ==0;
    }

}