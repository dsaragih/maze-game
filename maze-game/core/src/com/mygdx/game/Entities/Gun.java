package com.mygdx.game.Entities;

import com.mygdx.game.EntityManager;
import com.mygdx.game.IEntityManager;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.bullet.IBulletDrawer;
import com.mygdx.game.graphics.gun.IGunDrawer;

public class Gun extends Entity {

    private final IGunDrawer gunDrawer;
    private final IBulletDrawer bulletDrawer;
    private EntityManager entityManager;
    private final long cooldown = 200;
    private long lastAttack = 0;

    public Gun(Point pos, IGunDrawer gunDrawer, IBulletDrawer bulletDrawer){
        super(pos);
        this.gunDrawer = gunDrawer;
        this.bulletDrawer = bulletDrawer;
    }

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void fire(Point direction){
        long time = System.currentTimeMillis();
        if (time >= lastAttack + cooldown) {
            Bullet bullet = new Bullet(pos, direction.distanceVector(pos).normalized(), bulletDrawer);
            entityManager.addCollidableEntity(bullet);
            lastAttack = time;
        }
    }
//    public void setEntityManager(IEntityManager entityManager) {this.entityManager = entityManager;}

    public void setPosition(Point pos){
        this.pos = pos;
    }

    @Override
    public void draw() {
        gunDrawer.drawGun(pos);
    }
}
