package com.mygdx.game.graphics.entities.Boss;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Point;

public class CircleBossDrawer implements IBossDrawer{
    ShapeRenderer renderer;
    private int radius = 20;
    public CircleBossDrawer(ShapeRenderer renderer){this.renderer = renderer;}
    @Override
    public void drawBoss(Point pos) {
        renderer.setColor(Color.RED);
        renderer.circle(pos.x,pos.y, radius);
    }

    @Override
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
