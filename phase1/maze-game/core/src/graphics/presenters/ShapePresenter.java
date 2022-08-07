package graphics.presenters;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import config.GameConstants;
import graphics.entities.boss.CircleBossDrawer;
import graphics.entities.boss.IBossDrawer;
import graphics.entities.merchant.CircleMerchantDrawer;
import graphics.bullet.CircleBulletDrawer;
import graphics.bullet.IBulletDrawer;
import graphics.door.CircleDoorDrawer;
import graphics.door.IDoorDrawer;
import graphics.entities.merchant.IMerchantDrawer;
import graphics.entities.enemy.CircleEnemyDrawer;
import graphics.entities.enemy.IEnemyDrawer;
import graphics.gun.CircleGunDrawer;
import graphics.gun.IGunDrawer;
import graphics.healthbar.HealthBarDrawer;
import graphics.healthbar.IHealthBarDrawer;
import graphics.level.ILevelDrawer;
import graphics.level.LevelDrawer;
import graphics.entities.player.CirclePlayerDrawer;
import graphics.entities.player.IPlayerDrawer;
import graphics.presenters.IPresenter;
import graphics.room.IRoomDrawer;
import graphics.room.SandRoomDrawer;
import graphics.room.SimpleShapeRoomDrawer;

public class ShapePresenter implements IPresenter {
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    private int screenWidth;
    private int screenHeight;

    public ShapePresenter(int screenWidth, int screenHeight){
        spriteBatch =  new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    @Override
    public void onStartRender() {
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
    }

    @Override
    public void onEndRender() {
        shapeRenderer.end();
        spriteBatch.end();
    }

    public void dispose(){
        shapeRenderer.dispose();
        spriteBatch.dispose();
    }

    @Override
    public IDoorDrawer getDoorDrawer() {
        return new CircleDoorDrawer(shapeRenderer);
    }

    @Override
    public IRoomDrawer getRoomDrawer() {
        return new SimpleShapeRoomDrawer(shapeRenderer, screenWidth, screenHeight);
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

    public IMerchantDrawer getMerchantDrawer(){return new CircleMerchantDrawer(shapeRenderer);}

    @Override
    public IGunDrawer getGunDrawer() {
        return new CircleGunDrawer(shapeRenderer);
    }

    @Override
    public IBulletDrawer getBulletDrawer() {
        return new CircleBulletDrawer(shapeRenderer);
    }

    @Override
    public IBossDrawer getBossDrawer(){return new CircleBossDrawer(shapeRenderer);}

    @Override
    public IHealthBarDrawer getHealthBarDrawer() {
        return new HealthBarDrawer(shapeRenderer);
    }
}

