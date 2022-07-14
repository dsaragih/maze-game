package com.mygdx.game.graphics.door;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.door.IDoorDrawer;

public class CircleDoorDrawer implements IDoorDrawer {
    private ShapeRenderer shapeRenderer;
    private float radius = 10;

    public CircleDoorDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public void drawDoor(Point pos) {
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }
}
