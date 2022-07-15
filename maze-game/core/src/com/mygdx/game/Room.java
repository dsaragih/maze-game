package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.graphics.room.IRoomDrawer;
import com.mygdx.game.graphics.room.SimpleShapeRoomDrawer;
import com.mygdx.game.Entities.Enemy;

import java.util.*;

public class Room {
    private List<Door> doors = new ArrayList<>();
    private final int width = 960;
    private final int height = 540;
    private IRoomDrawer roomDrawer;
    private ArrayList<Entity> entities = new ArrayList<>();

    public Room(IRoomDrawer roomDrawer){
        this.roomDrawer = roomDrawer;
        entities.add(new Enemy(width / 4, height / 4, roomDrawer.getEntityDrawer()));
    }
    public void addDoor(Door door){
        doors.add(door);
    }

    public Room update(Player player){
        for(Door door: doors){
            if(door.getCollisionBox().intersects(player.getCollisionBox())){
                return door.collideWith(player);
            }
        }

        return this;
    }

    public void draw(){
        roomDrawer.drawRoom(entities, doors, width, height);
    }
}
