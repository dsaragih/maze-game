package com.mygdx.game;

import com.mygdx.game.Entities.CollidableEnitity;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.ICollidable;

import java.util.ArrayList;

public class RoomEntityManager implements IRoomEntityManager{
    private final ArrayList<Entity> Entities;
    private final ArrayList<CollidableEnitity> collidableEntities;

    public RoomEntityManager () {
        Entities = new ArrayList<>();
        collidableEntities = new ArrayList<>();
    }
    @Override
    public void addNonCollidableEntity (Entity ent) {Entities.add(ent);}
    @Override
    public void addCollidableEntity (CollidableEnitity ent) {
        collidableEntities.add(ent);
        Entities.add(ent);
    }
    @Override
    public void removeCollidableEntity (CollidableEnitity ent) {
        collidableEntities.remove(ent);
        Entities.remove(ent);
    }
    @Override
    public void removeNonCollidableEntity (Entity ent) {Entities.remove(ent);}

    public void update(){
        for(Entity entity: Entities){
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
    public void draw() {
        for (Entity ent: Entities) {
            ent.draw();
        }
    }
}
