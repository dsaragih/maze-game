package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;
import com.badlogic.gdx.graphics.Color;

public abstract class Entity implements IDrawble {
    Point pos;
    int radius;
    Color color;
    ShapeRenderer shapeRenderer;

    public Entity(float x, float y, ShapeRenderer shapeRenderer) {
        pos = new Point(x,y);
        this.shapeRenderer = shapeRenderer;
    }

    public Entity(Point pos) {
        this.pos = pos;
    }

    @Override
    public void draw() {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }
}
