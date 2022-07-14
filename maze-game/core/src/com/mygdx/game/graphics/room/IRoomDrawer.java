package com.mygdx.game.graphics.room;

import com.mygdx.game.Door;

import java.util.List;

public interface IRoomDrawer {
    public void drawRoom(List<Door> doors, int width, int height);
}
