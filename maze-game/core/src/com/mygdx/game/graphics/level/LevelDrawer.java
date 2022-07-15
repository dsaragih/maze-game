package com.mygdx.game.graphics.level;

import com.mygdx.game.Room;

public class LevelDrawer implements ILevelDrawer{
    @Override
    public void drawLevel(Room room) {
        room.draw();
    }
}
