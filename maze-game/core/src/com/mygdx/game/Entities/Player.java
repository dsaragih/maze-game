package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.EntityManager;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.entities.player.IPlayerDrawer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents the player
 * @author Ian
 * @author Ethan
 * @author Daniel.
 */
public class Player extends CollidableEntity {
    private final float speed = 200;
    private int health = 100;
    private final IPlayerDrawer playerDrawer;
    private final Collection<IPlayerObserver> observers = new ArrayList<>();
    private Point gunDirection = new Point(0,0);
    public Gun gun;

    /**
     * Create a player
     * @param pos The position of player
     * @param playerDrawer The drawer of player
     */
    public Player(Point pos, IPlayerDrawer playerDrawer){
        super(pos);
        this.playerDrawer = playerDrawer;
    }

    /**
     * Set up a gun manager for player
     * @param entityManager The manager of the player's guns
     */
    public void setGunEntityManager(EntityManager entityManager){
        gun.setEntityManager(entityManager);
    }

    /**
     * Set player's attack direction
     * @param direction The direction of player
     */
    public void fire(Point direction){
        gun.fire(direction);
    }

    /**
     * Set player's move direction
     * @param direction The direction of player
     */
    public void move(Point direction){
        direction.multiply(speed * Gdx.graphics.getDeltaTime());
        pos.add(direction);

        for(IPlayerObserver observer: observers){
            observer.setTarget(pos);
        }
        gun.setPosition(playerDrawer.getGunPos(pos, gunDirection));
    }

    /**
     * Set the mouse position for player
     * @param mousePos the mouse position.
     */
    public void setMousePos(Point mousePos){
        gunDirection = mousePos.distanceVector(pos);
        if(!gunDirection.isZero()){
            gunDirection = gunDirection.normalized();
        }
    }

    /**
     * Set the gun that is hold by player
     * @param gun the gun hold by player
     */
    public void setGun(Gun gun){
        this.gun = gun;
    }

    /**
     * Get the gun direction.
     * @return the gun direction
     */
    public Point getGunDirection() {
        System.out.println(gunDirection.x + " " + gunDirection.y);
        return gunDirection;
    }

    /**
     * Draw the player.
     */
    public void draw(){
        playerDrawer.drawPlayer(pos, gunDirection);
        gun.draw();
    }

    /**
     * Get the collision box
     * @return the circle representation of the collision box.
     */
    public Circle getCollisionBox(){
        return new Circle(pos, 10);
    }

    /**
     * Collide with another player.
     * @param player the player collided with the player
     */
    @Override
    public void collideWith(Player player) {

    }

    /**
     * Collide with another enemy.
     * @param enemy the enemy collided with player
     */
    public void collideWith(Enemy enemy) {
        health -= enemy.getDamage();
    }

    /**
     * Collide with another door.
     * @param door the door collided with player
     */
    @Override
    public void collideWith(Door door) {

    }

    /**
     * Collide with another bullet.
     * @param bullet the bullet collided with player
     */
    @Override
    public void collideWith(Bullet bullet) {

    }

    /**
     * Inform others being collided by player.
     * @param other the object collided with the player
     */
    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }

    /**
     * Add an observer
     * @param observer the observer added
     */
    public void addObserver(IPlayerObserver observer){
        observers.add(observer);
    }

    /**
     * Get the health of player
     * @return the health value of player.
     */
    public int getHealth(){
        return health;
    }
}
