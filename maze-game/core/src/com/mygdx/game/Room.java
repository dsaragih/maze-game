package com.mygdx.game;

import com.mygdx.game.Entities.CollidableEnitity;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.ICollidable;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.graphics.room.IRoomDrawer;

import java.util.*;

public class Room {
    private final IRoomDrawer roomDrawer;
    private final ArrayList<Entity> nonCollidableEntities = new ArrayList<>();
    private final ArrayList<CollidableEnitity> collidableEntities = new ArrayList<>();

    public Room(IRoomDrawer roomDrawer){
        this.roomDrawer = roomDrawer;
    }
    public void addNonCollidableEntity (Entity ent) {nonCollidableEntities.add(ent);}
    public void addCollidableEntity (CollidableEnitity ent) {
        collidableEntities.add(ent);
        nonCollidableEntities.add(ent);
    }

    public void update(){
        for(Entity entity: nonCollidableEntities){
            entity.update();
        }

        for(ICollidable e1: collidableEntities){
            for(ICollidable e2: collidableEntities){
                if(e1 == e2){
                    continue;
                }
                if(e1.getCollisionBox().intersects(e2.getCollisionBox())){
                    e1.informCollision(e2);
                    e2.informCollision(e1);
                }
            }
        }
    }

    public void draw(){
        roomDrawer.drawRoom(nonCollidableEntities);
    }
}
