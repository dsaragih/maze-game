package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.door.CircleDoorDrawer;
import com.mygdx.game.graphics.door.IDoorDrawer;

import java.util.Random;

public class Door {
    private Point pos;
    public Room room;
    public Door door;
    private final Random rand = new Random();
    private IDoorDrawer doorDrawer;
    public  Door(IDoorDrawer doorDrawer){
        this.pos = new Point(rand.nextFloat() * 960, rand.nextFloat() * 540);
        this.doorDrawer = doorDrawer;
    }

    public void setDoor(Door door){
        this.door = door;
    }

    public void setRoom(Room room){
        this.room = room;
    }
    public void draw(){
        doorDrawer.drawDoor(pos);
    }

    public Circle getCollisionBox(){
        return new Circle(pos, 10);
    }

    public Room collideWith(Player player){
        return door.room;
    }
}


