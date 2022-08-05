package entities;

import entities.item.Weapon;
import manager.IEntityManager;
import geometry.Point;
import graphics.bullet.IBulletDrawer;
import graphics.gun.IGunDrawer;

public class Gun extends Weapon {

    private final IGunDrawer gunDrawer;
    private final IBulletDrawer bulletDrawer;
    private IEntityManager entityManager;
    private final long cooldown = 200;
    private long lastAttack = 0;

    private int damage = 15;

    private final int value = 30;

    private String name = "Default Gun";

    public Gun(Point pos, IGunDrawer gunDrawer, IBulletDrawer bulletDrawer){
        super(pos);
        this.gunDrawer = gunDrawer;
        this.bulletDrawer = bulletDrawer;
        damage = 15;
    }

    public void setEntityManager(IEntityManager entityManager){
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
//    public void setEntityManager(manager.IEntityManager entityManager) {this.entityManager = entityManager;}

    public void setPosition(Point pos){
        this.pos = pos;
    }

    @Override
    public void draw() {
        gunDrawer.drawGun(pos);
    }

    @Override
    public String toString(){
        return name;
    }
}
