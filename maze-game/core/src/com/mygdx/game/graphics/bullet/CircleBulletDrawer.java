package com.mygdx.game.graphics.bullet;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Entities.Bullet;
import com.mygdx.game.geometry.Point;

public class CircleBulletDrawer implements IBulletDrawer{
    private int radius = 1;
    private ShapeRenderer shapeRenderer;

    public CircleBulletDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public void drawBullet(Point pos) {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }
}
