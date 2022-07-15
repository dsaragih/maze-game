package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.graphics.entities.IEntityDrawer;

public abstract class Entity implements IDrawble {
    Point pos;
    int radius;
    Color color;
    IEntityDrawer entityDrawer;

    public Entity(float x, float y, IEntityDrawer entityDrawer) {
        pos = new Point(x,y);
        this.entityDrawer = entityDrawer;
    }

    public Entity(Point pos) {
        this.pos = pos;
    }

    @Override
    public void draw() {
        entityDrawer.drawEntity(pos, radius, color);
    }
}
