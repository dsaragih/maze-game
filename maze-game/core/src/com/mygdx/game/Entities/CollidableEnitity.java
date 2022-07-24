package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;

/** Represents a collidable object
 * @author Ethan
 * @author Ian
 */
public abstract class CollidableEnitity extends Entity implements ICollidable{

    /**
     * Create a collidable entity with the position
     * @param pos position of the entity
     */
    public CollidableEnitity(Point pos) {
        super(pos);
    }

    /**
     * Create a collidable entity with coordinate (x,y)
     * @param x the horizontal coordinate of the entity
     * @param y the vertical coordinate of the entity
     */
    public CollidableEnitity(float x, float y) {
        super(x, y);
    }
}
