package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.bullet.IBulletDrawer;

public class Bullet extends CollidableEnitity{

    private int BULLET_DAMAGE = 25;
    private Point velocity = new Point(0, 0);
    private final Point target;

    private IBulletDrawer bulletDrawer;


    public Bullet(float x, float y, Point target) {
        super(x, y);
        this.target = target;
    }

    @Override
    public void draw() {
        bulletDrawer.drawBullet(pos);
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(this.pos, 1);
    }

    @Override
    public void collideWith(Player player) {

    }

    @Override
    public void collideWith(Enemy enemy) {
        //enemy.collideWith(this);
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
        if(target == null){
            return;
        }

        Point dirVector = target.distanceVector(pos).normalized();
        velocity.add(dirVector);
        if(velocity.isZero()){
            return;
        }

        pos.add(velocity);
    }

    public int getDamage() {
        return BULLET_DAMAGE;
    }

    public void setDamage(int BULLET_DAMAGE) {
        this.BULLET_DAMAGE = BULLET_DAMAGE;
    }
}
