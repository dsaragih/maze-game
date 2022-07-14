package com.mygdx.game.graphics.room;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Door;

import java.util.List;

public class SimpleShapeRoomDrawer implements IRoomDrawer{

    private ShapeRenderer shapeRenderer;
    public SimpleShapeRoomDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawRoom(List<Door> doors, int width, int height) {
        shapeRenderer.setColor(Color.GRAY);
        shapeRenderer.rect(0, 0, width, height);
        for(Door door: doors){
            door.draw();
        }
    }
}
