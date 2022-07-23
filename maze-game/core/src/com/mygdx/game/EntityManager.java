package com.mygdx.game;

import com.mygdx.game.Entities.CollidableEntity;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.ICollidable;

import java.util.ArrayList;

public class RoomEntityManager implements IRoomEntityManager{
    private final ArrayList<Entity> Entities;
    private final ArrayList<CollidableEntity> collidableEntities;
    private final ArrayList<Entity> toBeAddedEntities;
    private final ArrayList<Entity> toBeRemovedEntities;
    private final ArrayList<CollidableEntity> toBeAddedCollidable;
    private final ArrayList<CollidableEntity> toBeRemovedCollidable;


    public RoomEntityManager () {
        Entities = new ArrayList<>();
        collidableEntities = new ArrayList<>();
        toBeAddedEntities = new ArrayList<>();
        toBeRemovedEntities = new ArrayList<>();
        toBeAddedCollidable = new ArrayList<>();
        toBeRemovedCollidable = new ArrayList<>();
    }
    @Override
    public void addNonCollidableEntity (Entity ent) {toBeAddedEntities.add(ent);}
    @Override
    public void addCollidableEntity (CollidableEntity ent) {
        toBeAddedCollidable.add(ent);
        toBeAddedEntities.add(ent);
    }
    @Override
    public void removeCollidableEntity (CollidableEntity ent) {
        toBeRemovedCollidable.add(ent);
        toBeRemovedEntities.add(ent);
    }
    @Override
    public void removeNonCollidableEntity (Entity ent) {toBeRemovedEntities.add(ent);}

    public void update(){
        Entities.addAll(toBeAddedEntities);
        collidableEntities.addAll(toBeAddedCollidable);
        Entities.removeAll(toBeRemovedEntities);
        collidableEntities.removeAll(toBeRemovedCollidable);

        toBeAddedEntities.clear();
        toBeAddedCollidable.clear();
        toBeRemovedEntities.clear();
        toBeRemovedCollidable.clear();

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
