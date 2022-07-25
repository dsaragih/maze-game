package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Circle;

/**
 * Represents the collidable interface
 * @author Ethan
 * @author Daniel
 */
public interface ICollidable {

    /**
     * Get the collision box.
     * @return the circle representation of collision box
     */
    public Circle getCollisionBox();

    /**
     * Collide with player
     * @param player the player being collided.
     */
    public void collideWith(Player player);

    /**
     * Collide with enemy
     * @param enemy the enemy being collided.
     */
    public void collideWith(Enemy enemy);

    /**
     * Collide with door
     * @param door the door being collided.
     */
    public void collideWith(Door door);

    /**
     * Collide with bullet
     * @param bullet the bullet being collided.
     */
    public void collideWith(Bullet bullet);

    /**
     * Inform the ICollidable objects being collided
     * @param other object being collided
     */
    public void informCollision(ICollidable other);
}
