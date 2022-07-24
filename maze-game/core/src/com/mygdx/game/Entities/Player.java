package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.EntityManager;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.entities.player.IPlayerDrawer;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends CollidableEntity {
    private final float speed = 200;
    private int health = 100;
    private final IPlayerDrawer playerDrawer;
    private final Collection<IPlayerObserver> observers = new ArrayList<>();
    private Point gunDirection = new Point(0,0);
    public Gun gun;

    public Player(Point pos, IPlayerDrawer playerDrawer){
        super(pos);
        this.playerDrawer = playerDrawer;
    }

    public void setGunEntityManager(EntityManager entityManager){
        gun.setEntityManager(entityManager);
    }

    public void fire(Point direction){
        gun.fire(direction);
    }

    public void move(Point direction){
        direction.multiply(speed * Gdx.graphics.getDeltaTime());
        pos.add(direction);

        for(IPlayerObserver observer: observers){
            observer.setTarget(pos);
        }
        gun.setPosition(playerDrawer.getGunPos(pos, gunDirection));
    }

    public void setMousePos(Point mousePos){
        gunDirection = mousePos.distanceVector(pos);
        if(!gunDirection.isZero()){
            gunDirection = gunDirection.normalized();
        }
    }

    public void setGun(Gun gun){
        this.gun = gun;
    }
    public Point getGunDirection() {
        System.out.println(gunDirection.x + " " + gunDirection.y);
        return gunDirection;
    }

    public void draw(){
        playerDrawer.drawPlayer(pos, gunDirection);
        gun.draw();
    }

    public Circle getCollisionBox(){
        return new Circle(pos, 10);
    }

    @Override
    public void collideWith(Player player) {

    }


    public void collideWith(Enemy enemy) {
        health -= enemy.getDamage();
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

    public void addObserver(IPlayerObserver observer){
        observers.add(observer);
    }

    public int getHealth(){
        return health;
    }
}
