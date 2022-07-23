package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;

public abstract class CollidableEnitity extends Entity implements ICollidable{

    public CollidableEnitity(Point pos) {
        super(pos);
    }

    public CollidableEnitity(float x, float y) {
        super(x, y);
    }
}
