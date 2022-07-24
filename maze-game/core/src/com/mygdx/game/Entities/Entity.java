package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;

/** Represents an entity
 * @author Ethan
 * @author Ian Curtis Ewing
 * @author Daniel
 */
public abstract class Entity implements IDrawble {
    Point pos;

    /**
     * Create an entity
     * @param x the x-coordinate of the entity
     * @param y the x-coordinate of the entity
     */
    public Entity(float x, float y) {
        pos = new Point(x,y);
    }

    /**
     * Create an entity
     * @param pos the position of the entity
     */
    public Entity(Point pos) {
        this.pos = pos;
    }

    /**
     * Draw the entity.
     */
    @Override
    public abstract void draw();

    /**
     * Update the entity.
     */
    public void update() {

    }

    /**
     * Determine whether the entity should be removed.
     * @return it should not be removed.
     */
    public boolean shouldBeRemoved(){
        return false;
    }
}
