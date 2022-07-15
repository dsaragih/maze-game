package com.mygdx.game.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.door.CircleDoorDrawer;
import com.mygdx.game.graphics.door.IDoorDrawer;
import com.mygdx.game.graphics.level.ILevelDrawer;
import com.mygdx.game.graphics.level.LevelDrawer;
import com.mygdx.game.graphics.player.CirclePlayerDrawer;
import com.mygdx.game.graphics.player.IPlayerDrawer;
import com.mygdx.game.graphics.room.IRoomDrawer;
import com.mygdx.game.graphics.room.SimpleShapeRoomDrawer;

public class ShapePresenter implements IPresenter {
    private final ShapeRenderer shapeRenderer;
    public ShapePresenter(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public IDoorDrawer getDoorDrawer() {
        return new CircleDoorDrawer(shapeRenderer);
    }

    @Override
    public IRoomDrawer getRoomDrawer() {
        return new SimpleShapeRoomDrawer(shapeRenderer);
    }

    @Override
    public ILevelDrawer getLevelDrawer() {
        return new LevelDrawer();
    }

    @Override
    public IPlayerDrawer getPlayerDrawer() {
        return new CirclePlayerDrawer(shapeRenderer);
    }

}
