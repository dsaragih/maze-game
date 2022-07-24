package com.mygdx.game.Entities;

import com.mygdx.game.EntityManager;
import com.mygdx.game.geometry.Point;

public abstract class CollidableEntity extends Entity implements ICollidable{

    /**
     * Create a collidable entity with the position
     * @param pos position of the entity
     */
    public CollidableEntity(Point pos) {
        super(pos);
    }

    /**
     * Create a collidable entity with coordinate (x,y)
     * @param x the horizontal coordinate of the entity
     * @param y the vertical coordinate of the entity
     */
    public CollidableEntity(float x, float y) {
        super(x, y);
    }

    @Override
    public void removeSelf(EntityManager entityManager){
        entityManager.removeEntity(this);
    }
}
