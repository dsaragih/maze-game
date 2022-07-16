package com.mygdx.game.graphics.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Point;
import com.badlogic.gdx.graphics.Color;

public class CircleEntityDrawer implements IEntityDrawer {
    private ShapeRenderer shapeRenderer;
    public CircleEntityDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public void drawEntity(Point pos, int radius, Color color) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }
}
