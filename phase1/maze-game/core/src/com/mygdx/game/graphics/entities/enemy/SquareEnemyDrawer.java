package com.mygdx.game.graphics.entities.enemy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Point;

public class SquareEnemyDrawer implements IEnemyDrawer{

    private int sideLength = 20;
    private ShapeRenderer shapeRenderer;
    public SquareEnemyDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawEnemy(Point pos) {
        shapeRenderer.setColor(Color.NAVY);
        shapeRenderer.rect(pos.x, pos.y, sideLength, sideLength);
    }
}
