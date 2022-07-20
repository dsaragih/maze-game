package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.gun.IBulletDrawer;


public class Bullet extends CollidableEnitity{
    private IBulletDrawer bulletDrawer;
    float damage;

    public Bullet(Point pos, float damage, IBulletDrawer bulletDrawer) {
        super(pos);
        this.damage = damage;
        this.bulletDrawer = bulletDrawer;
    }
    public float getDamage() { return damage; }
    @Override
    public void draw() {
        bulletDrawer.drawBullet(pos);
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(pos, 2);
    }

    @Override
    public void collideWith(Player player) {

    }

    @Override
    public void collideWith(Enemy enemy) {

    }

    @Override
    public void collideWith(Door door) {

    }
    @Override
    public void collideWith(Bullet bullet) {

    }

    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }
}
