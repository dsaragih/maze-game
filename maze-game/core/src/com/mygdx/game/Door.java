package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Door {
    private Point pos;
    private final float radius = 10;
    public Room room1;
    public Room room2;
    private final Random rand = new Random();
    public  Door(Room room1, Room room2){
        this.pos = new Point(rand.nextFloat() * 960, rand.nextFloat() * 540);
        this.room1 = room1;
        this.room2 = room2;
    }
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }

    public Circle getCollisionBox(){
        return new Circle(pos, radius);
    }

    public boolean collideWith(Player player){
        return true;
    }
}


