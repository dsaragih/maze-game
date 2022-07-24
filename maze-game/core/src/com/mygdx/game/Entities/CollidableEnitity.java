package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;

/** Represents a collidable object
 * @author Ethan
 */
public abstract class CollidableEnitity extends Entity implements ICollidable{

    /**
     *
     * @param pos position of the entity
     */
    public CollidableEnitity(Point pos) {
        super(pos);
    }

    public CollidableEnitity(float x, float y) {
        super(x, y);
    }
}
