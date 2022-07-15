package com.mygdx.game.graphics;

import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.door.IDoorDrawer;
import com.mygdx.game.graphics.level.ILevelDrawer;
import com.mygdx.game.graphics.player.IPlayerDrawer;
import com.mygdx.game.graphics.room.IRoomDrawer;

public interface IPresenter {
    public IDoorDrawer getDoorDrawer();
    public IRoomDrawer getRoomDrawer();

    public ILevelDrawer getLevelDrawer();

    public IPlayerDrawer getPlayerDrawer();

}
