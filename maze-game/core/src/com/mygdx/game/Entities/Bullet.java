package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.bullet.IBulletDrawer;
/** Represents a bullet.
 * @author Daniel Saragih
 * @author Ian Curtis Ewing
 */
public class Bullet extends CollidableEntity {

    private int BULLET_DAMAGE = 15;
    private final Point velocity;
    private final float speed = 30;
    private boolean isHit = false;

    private final IBulletDrawer bulletDrawer;

    /** Creates a bullet with the specified name.
     * @param pos Position of the bullet.
     * @param direction Direction vector of the bullet.
     * @param bulletDrawer Drawer of the bullet.
     */
    public Bullet(Point pos, Point direction, IBulletDrawer bulletDrawer) {
        super(pos);
        direction.multiply(speed);
        this.velocity = direction;
        this.bulletDrawer = bulletDrawer;
    }

    /** Draw the bullet
     */
    @Override
    public void draw() {
        bulletDrawer.drawBullet(pos);
    }

    /** Get the Collision Box
     * @return a circle representation of the collision box.
     */
    @Override
    public Circle getCollisionBox() {
        return new Circle(this.pos, 4);
    }

    /** Collide with the player
     * @param player The player being hit by the bullet.
     */
    public void collideWith(Player player) {

    }

    /** Collide with enemy player
     * @param enemy The enemy being hit by the bullet.
     */
    public void collideWith(Enemy enemy) {
        isHit = true;
    }

    /** Collide with enemy player
     * @param door The door being hit by the bullet.
     */
    @Override
    public void collideWith(Door door) {

    }

    /** Collide with another bullet
     * @param bullet Another bullet being hit by this bullet
     */
    @Override
    public void collideWith(Bullet bullet) {

    }

    /** Inform the object that it's hit by the bullet
     * @param other the object being hit by this bullet
     */
    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }

    /** Update the position of bullet
     */
    public void update() {
        pos.add(velocity);
    }

    /** Get the bullet damage
     * @return The damage of the bullet
     */
    public int getDamage() {
        return BULLET_DAMAGE;
    }

    /**
     * Return true if it hits another object, false otherwise.
     * @return whether the bullet hits another abject
     */
    @Override
    public boolean shouldBeRemoved() {
        return isHit;
    }
}
