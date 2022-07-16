package com.mygdx.game.graphics;

import com.badlogic.gdx.graphics.Camera;
import com.mygdx.game.graphics.door.IDoorDrawer;
import com.mygdx.game.graphics.entities.enemy.IEnemyDrawer;
import com.mygdx.game.graphics.level.ILevelDrawer;
import com.mygdx.game.graphics.entities.player.IPlayerDrawer;
import com.mygdx.game.graphics.room.IRoomDrawer;

public interface IPresenter {

    public void start(Camera camera);
    public void end();
    public IDoorDrawer getDoorDrawer();
    public IRoomDrawer getRoomDrawer();

    public ILevelDrawer getLevelDrawer();

    public IPlayerDrawer getPlayerDrawer();

    public IEnemyDrawer getEnemyDrawer();

}
