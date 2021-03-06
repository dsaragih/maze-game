package com.mygdx.game.graphics.entities;
import com.mygdx.game.geometry.Point;
import com.badlogic.gdx.graphics.Color;

public interface IEntityDrawer {

    public void drawEntity(Point pos, int radius, Color color);
}
