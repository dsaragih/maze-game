package com.mygdx.game.Entities;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.entities.enemy.IEnemyDrawer;

public class Enemy extends CollidableEnitity implements IPlayerObserver {
    private Point velocity = new Point(0,0);
    private final float ACCELERATION = 10;
    private final float FRICTION = 0.02f;
    private final float MAX_SPEED = 20;
    private IEnemyDrawer enemyDrawer;
    private int health = 100;
    private int damage = 1;

    private Point target = null;

    public Enemy(int x, int y, IEnemyDrawer enemyDrawer) {
        super(x, y);
        this.enemyDrawer = enemyDrawer;
    }

    public Enemy(Point pos, IEnemyDrawer enemyDrawer) {
        super(pos);
        this.enemyDrawer = enemyDrawer;
    }

    public Circle getCollisionBox(){
        return new Circle(pos, 15);
    }


    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }

    public void collideWith(Player player) {
        Point dir = player.pos.distanceVector(pos).normalized();
        dir.multiply(-1f);
        velocity.add(dir);
    }

    @Override
    public void collideWith(Enemy enemy) {
        Point dir = enemy.pos.distanceVector(pos).normalized();
        dir.multiply(-1f);
        velocity.add(dir);
    }

    @Override
    public void collideWith(Door door) {

    }

    @Override
    public void draw() {
        enemyDrawer.drawEnemy(pos);
    }

    public void update() {
        if(target == null){
            return;
        }

        Point dirVector = target.distanceVector(pos).normalized();
        dirVector.multiply(ACCELERATION * Gdx.graphics.getDeltaTime());
        velocity.add(dirVector);
        velocity.multiply(1 - FRICTION);
        if(velocity.isZero()){
            return;
        }
        Point newDir = velocity.normalized();
        if(newDir.length() > MAX_SPEED){
            newDir.multiply(MAX_SPEED);
            velocity = newDir;
        }

        pos.add(velocity);
    }

    public int getDamage(){
        return damage;
    }

    public void setTarget(Point newTarget){
        target = newTarget;
    }
}
