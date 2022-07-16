package com.mygdx.game.graphics.room;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Entities.Door;
import com.mygdx.game.Entities.Entity;

import java.util.List;

public class SimpleShapeRoomDrawer implements IRoomDrawer{

    private final ShapeRenderer shapeRenderer;
    private final int screenWidth;
    private final int screenHeight;
    public SimpleShapeRoomDrawer(ShapeRenderer shapeRenderer, int screenWidth, int screenHeight){
        this.shapeRenderer = shapeRenderer;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    @Override
    public void drawRoom(List<Entity> entities) {
        shapeRenderer.setColor(Color.GRAY);
        shapeRenderer.rect(0, 0, screenWidth, screenHeight);
        for (Entity ent: entities) {
            ent.draw();
        }
    }

}
