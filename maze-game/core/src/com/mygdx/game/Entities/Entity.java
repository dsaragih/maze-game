package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;

public abstract class Entity implements IDrawble {
    Point pos;

    public Entity(float x, float y) {
        pos = new Point(x,y);
    }

    public Entity(Point pos) {
        this.pos = pos;
    }

    @Override
    public abstract void draw();
    public void update() {

    }

    public boolean shouldBeRemoved(){
        return false;
    }
}
