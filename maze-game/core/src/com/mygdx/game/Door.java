package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Door {
    private Point pos;
    private final float radius = 10;
    public Room room;
    public Door door;
    private final Random rand = new Random();
    public  Door(){
        this.pos = new Point(rand.nextFloat() * 960, rand.nextFloat() * 540);
    }

    public void setDoor(Door door){
        this.door = door;
    }

    public void setRoom(Room room){
        this.room = room;
    }
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }

    public Circle getCollisionBox(){
        return new Circle(pos, radius);
    }

    public Room collideWith(Player player){
        return door.room;
    }
}


