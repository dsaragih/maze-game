package graphics;

import com.badlogic.gdx.graphics.Camera;
import graphics.entities.boss.IBossDrawer;
import graphics.bullet.IBulletDrawer;
import graphics.door.IDoorDrawer;
import graphics.entities.merchant.IMerchantDrawer;
import graphics.entities.enemy.IEnemyDrawer;
import graphics.gun.IGunDrawer;
import graphics.level.ILevelDrawer;
import graphics.entities.player.IPlayerDrawer;
import graphics.room.IRoomDrawer;

public interface IPresenter {

    void start(Camera camera);
    void end();
    IDoorDrawer getDoorDrawer();
    IRoomDrawer getRoomDrawer();

    ILevelDrawer getLevelDrawer();

    IPlayerDrawer getPlayerDrawer();

    IEnemyDrawer getEnemyDrawer();
    IGunDrawer getGunDrawer();

    IMerchantDrawer getMerchantDrawer();

    IBulletDrawer getBulletDrawer();

    IBossDrawer getBossDrawer();
}
