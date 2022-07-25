package com.mygdx.game.graphics.gun;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Point;

public class CircleGunDrawer implements IGunDrawer{

    private int radius = 2;
    private ShapeRenderer shapeRenderer;
    public CircleGunDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawGun(Point pos) {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }
}
