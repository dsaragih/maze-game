package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.*;

public class Room {
    private List<Door> doors = new ArrayList<>();
    private final float width = 960;
    private final float height = 540;
    public void addDoor(Door door){
        doors.add(door);
    }

    public void update(Player player){
        for(Door door: doors){
            if(door.getCollisionBox().intersects(player.getCollisionBox())){
                door.collideWith(player);
            }
        }
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.GRAY);
        shapeRenderer.rect(0, 0, width, height);
        for(Door door: doors){
            door.draw(shapeRenderer);
        }
    }
}
