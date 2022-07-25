package com.mygdx.game.graphics.entities.player;

import com.mygdx.game.geometry.Point;

public interface IPlayerDrawer {
    public void drawPlayer(Point pos, Point gunDirection);
    public Point getGunPos(Point playerPos, Point gunDirection);
}
