package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Point;

public abstract class CollidableEntity extends Entity implements ICollidable{

    public CollidableEntity(Point pos) {
        super(pos);
    }

    public CollidableEntity(float x, float y) {
        super(x, y);
    }
}
