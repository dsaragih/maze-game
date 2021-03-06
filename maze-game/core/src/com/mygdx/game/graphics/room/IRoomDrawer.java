package com.mygdx.game.graphics.room;

import com.mygdx.game.Door;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.graphics.entities.IEntityDrawer;

import java.util.List;

public interface IRoomDrawer {
    public void drawRoom(List<Entity> entities, List<Door> doors, int width, int height);
}
