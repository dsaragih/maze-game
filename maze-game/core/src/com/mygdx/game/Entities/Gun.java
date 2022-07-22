package com.mygdx.game.Entities;

import com.mygdx.game.IRoomEntityManager;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.bullet.IBulletDrawer;
import com.mygdx.game.graphics.gun.IGunDrawer;

public class Gun extends Entity {

    private IGunDrawer gunDrawer;
    private IBulletDrawer bulletDrawer;
    private IRoomEntityManager entityManager;

    public Gun(Point pos, IGunDrawer gunDrawer, IBulletDrawer bulletDrawer){
        super(pos);
        this.gunDrawer = gunDrawer;
        this.bulletDrawer = bulletDrawer;
    }

    public void fire(Point direction){
        Bullet bullet = new Bullet(pos, direction.distanceVector(pos).normalized(), bulletDrawer, entityManager);
        entityManager.addCollidableEntity(bullet);
    }
    public void setEntityManager(IRoomEntityManager entityManager) {this.entityManager = entityManager;}

    public void setPosition(Point pos){
        this.pos = pos;
    }

    @Override
    public void draw() {
        gunDrawer.drawGun(pos);
    }
}
