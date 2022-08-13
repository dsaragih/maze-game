package game.entities.item;

import config.GameConstants;
import game.entities.abstractions.Entity;
import manager.IEntityManager;
import geometry.Point;
import graphics.entityDrawers.bullet.IBulletDrawer;
import graphics.entityDrawers.gun.IGunDrawer;

public class Gun extends Entity {

    private final IGunDrawer gunDrawer;
    private final IBulletDrawer bulletDrawer;
    private IEntityManager entityManager;
    private long lastAttack = 0;

    public Gun(final Point pos, final IGunDrawer gunDrawer, final IBulletDrawer bulletDrawer){
        super(pos);
        this.gunDrawer = gunDrawer;
        this.bulletDrawer = bulletDrawer;
    }

    public void setEntityManager(final IEntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void fire(final Point direction){
        final long time = System.currentTimeMillis();
        if (time >= lastAttack + GameConstants.GUN_COOL_DOWN) {
            final Bullet bullet = new Bullet(pos, direction.distanceVector(pos).normalized(), bulletDrawer);
            entityManager.addCollidableEntity(bullet);
            lastAttack = time;
        }
    }

    public void setPlayerPosition(final Point playerPos){
        pos = playerPos;
    }

    @Override
    public void draw() {
        gunDrawer.drawGun(pos);
    }
}
