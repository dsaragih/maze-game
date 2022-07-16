package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.graphics.entities.IEntityDrawer;

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
    public void update(Player player) {

    }
}
