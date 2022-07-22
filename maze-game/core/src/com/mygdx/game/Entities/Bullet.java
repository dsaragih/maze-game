package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.IRoomEntityManager;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.bullet.IBulletDrawer;

public class Bullet extends CollidableEnitity{

    private int BULLET_DAMAGE = 25;
    private Point velocity;
    private float speed = 30;

    private IBulletDrawer bulletDrawer;
    private IRoomEntityManager entityManager;


    public Bullet(Point pos, Point direction, IBulletDrawer bulletDrawer, IRoomEntityManager entityManager) {
        super(pos);
        direction.multiply(speed);
        this.velocity = direction;
        this.bulletDrawer = bulletDrawer;
        this.entityManager = entityManager;
    }

    @Override
    public void draw() {
        bulletDrawer.drawBullet(pos);
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(this.pos, 2);
    }

    public void collideWith(Player player) {

    }

    public void collideWith(Enemy enemy) {
       enemy.collideWith(this);
       //entityManager.removeCollidableEntity(this);
        /*
         * The main issue with this is that a List is being edited while iterating on it
         * to check collisions. Consider adding "toBeAdded" and "toBeRemoved" Lists in EntityManager.
         */
    }

    @Override
    public void collideWith(Door door) {

    }

    @Override
    public void collideWith(Bullet bullet) {

    }

    @Override
    public void informCollision(ICollidable other) {

    }

    public void update() {
        pos.add(velocity);
    }

    public int getDamage() {
        return BULLET_DAMAGE;
    }

    public void setDamage(int BULLET_DAMAGE) {
        this.BULLET_DAMAGE = BULLET_DAMAGE;
    }
}
