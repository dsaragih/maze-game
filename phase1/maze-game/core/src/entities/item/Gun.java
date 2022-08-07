package entities.item;

import config.GameConstants;
import manager.IEntityManager;
import geometry.Point;
import graphics.bullet.IBulletDrawer;
import graphics.gun.IGunDrawer;

public class Gun extends Weapon {

    private IGunDrawer gunDrawer;
    private IBulletDrawer bulletDrawer;
    private IEntityManager entityManager;
    private long lastAttack = 0;

    private String name = "Default Gun";

    public Gun(Point pos, IGunDrawer gunDrawer, IBulletDrawer bulletDrawer){
        super(pos);
        this.gunDrawer = gunDrawer;
        this.bulletDrawer = bulletDrawer;
    }

    public void setEntityManager(IEntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void rename(String name){
        this.name = name;
    }

    public void fire(Point direction){
        long time = System.currentTimeMillis();
        if (time >= lastAttack + GameConstants.GUN_COOLDOWN) {
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
