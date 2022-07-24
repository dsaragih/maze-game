package com.mygdx.game.Entities;

import com.mygdx.game.EntityManager;
import com.mygdx.game.IEntityManager;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.bullet.IBulletDrawer;

public class Bullet extends CollidableEntity {

    private int BULLET_DAMAGE = 25;
    private final Point velocity;
    private final float speed = 30;
    private boolean isHit = false;

    private final IBulletDrawer bulletDrawer;


    public Bullet(Point pos, Point direction, IBulletDrawer bulletDrawer) {
        super(pos);
        direction.multiply(speed);
        this.velocity = direction;
        this.bulletDrawer = bulletDrawer;
    }

    @Override
    public void draw() {
        bulletDrawer.drawBullet(pos);
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(this.pos, 4);
    }

    public void collideWith(Player player) {

    }

    public void collideWith(Enemy enemy) {
        isHit = true;
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

    public void update() {
        pos.add(velocity);
    }

    public int getDamage() {
        return BULLET_DAMAGE;
    }

    @Override
    public boolean shouldBeRemoved() {
        return isHit;
    }
}
