package com.mygdx.game.graphics;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.graphics.entities.Merchant.CircleMerchantDrawer;
import com.mygdx.game.graphics.bullet.CircleBulletDrawer;
import com.mygdx.game.graphics.bullet.IBulletDrawer;
import com.mygdx.game.graphics.door.CircleDoorDrawer;
import com.mygdx.game.graphics.door.IDoorDrawer;
import com.mygdx.game.graphics.entities.Merchant.IMerchantDrawer;
import com.mygdx.game.graphics.entities.enemy.CircleEnemyDrawer;
import com.mygdx.game.graphics.entities.enemy.IEnemyDrawer;
import com.mygdx.game.graphics.gun.CircleGunDrawer;
import com.mygdx.game.graphics.gun.IGunDrawer;
import com.mygdx.game.graphics.level.ILevelDrawer;
import com.mygdx.game.graphics.level.LevelDrawer;
import com.mygdx.game.graphics.entities.player.CirclePlayerDrawer;
import com.mygdx.game.graphics.entities.player.IPlayerDrawer;
import com.mygdx.game.graphics.room.IRoomDrawer;
import com.mygdx.game.graphics.room.SimpleShapeRoomDrawer;

public class ShapePresenter implements IPresenter {
    private final ShapeRenderer shapeRenderer;
    private Stage stage;
    private int screenWidth;
    private int screenHeight;

    public ShapePresenter(ShapeRenderer shapeRenderer, Stage stage, int screenWidth, int screenHeight){
        this.stage = stage;
        this.shapeRenderer = shapeRenderer;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    @Override
    public void start(Camera camera) {
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    }

    @Override
    public void end() {
        shapeRenderer.end();
    }

    @Override
    public IDoorDrawer getDoorDrawer() {
        return new CircleDoorDrawer(shapeRenderer);
    }

    @Override
    public IRoomDrawer getRoomDrawer() {
        return new SimpleShapeRoomDrawer(shapeRenderer, stage, screenWidth, screenHeight);
    }

    @Override
    public ILevelDrawer getLevelDrawer() {
        return new LevelDrawer();
    }

    @Override
    public IPlayerDrawer getPlayerDrawer() {
        return new CirclePlayerDrawer(shapeRenderer);
    }

    @Override
    public IEnemyDrawer getEnemyDrawer() {
        return new CircleEnemyDrawer(shapeRenderer);
    }

    public IMerchantDrawer getMerchantDrawer(){return new CircleMerchantDrawer(shapeRenderer, stage);}

    @Override
    public IGunDrawer getGunDrawer() {
        return new CircleGunDrawer(shapeRenderer);
    }

    @Override
    public IBulletDrawer getBulletDrawer() {
        return new CircleBulletDrawer(shapeRenderer);
    }
}
