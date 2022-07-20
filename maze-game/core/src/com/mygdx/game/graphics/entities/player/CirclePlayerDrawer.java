package com.mygdx.game.graphics.entities.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Point;

public class CirclePlayerDrawer implements IPlayerDrawer{

    private int radius = 10;
    private ShapeRenderer shapeRenderer;
    public CirclePlayerDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawPlayer(Point pos, Point gunDirection) {
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.circle(pos.x, pos.y, radius);
//        shapeRenderer.setColor(Color.BLACK);
//
//        shapeRenderer.circle(pos.x + gunDirection.x * radius, pos.y + gunDirection.y * radius, 3);
    }

    @Override
    public Point getGunPos(Point playerPos, Point gunDirection) {
        return new Point(playerPos.x + gunDirection.x * radius, playerPos.y + gunDirection.y * radius);
    }
}
