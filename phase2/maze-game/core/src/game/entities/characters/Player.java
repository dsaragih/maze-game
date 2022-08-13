package game.entities.characters;

import com.badlogic.gdx.Gdx;
import config.GameConstants;
import game.entities.item.Mine;
import game.entities.abstractions.CollidableEntity;
import game.entities.abstractions.ICollidable;
import game.entities.abstractions.IPlayerObserver;
import game.entities.item.Gun;
import manager.IEntityManager;
import geometry.Circle;
import geometry.Point;
import graphics.entityDrawers.player.IPlayerDrawer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents the player
 * @author Ian
 * @author Ethan
 * @author Daniel.
 */
public class Player extends CollidableEntity {

    private int health = GameConstants.PLAYER_MAX_HEALTH;
    private int shield = 0;
    private final IPlayerDrawer playerDrawer;
    private final Collection<IPlayerObserver> observers = new ArrayList<>();
    private Point gunDirection = new Point(0,0);
    private Gun gun;
    private float armourDamageFactor = 1;

    private int goldOwned = 100;


    /**
     * Create a player
     * @param pos The position of player
     * @param playerDrawer The drawer of player
     */
    public Player(final Point pos, final IPlayerDrawer playerDrawer){
        super(pos);
        this.playerDrawer = playerDrawer;
    }

    /**
     * Set up a gun manager for player
     * @param entityManager The manager of the player's guns
     */
    public void setGunEntityManager(final IEntityManager entityManager){
        gun.setEntityManager(entityManager);
    }

    /**
     * Set player's attack direction
     * @param direction The direction of player
     */
    public void fire(final Point direction){
        gun.fire(direction);
    }

    /**
     * Set player's move direction
     * @param direction The direction of player
     */
    public void move(final Point direction){
        //move in the given direction
        direction.multiply(GameConstants.PLAYER_SPEED * Gdx.graphics.getDeltaTime());
        pos.add(direction);

        //keep player on the screen
        pos.setX(Math.max(Math.min(pos.getX(), GameConstants.SCREEN_WIDTH), 0));
        pos.setY(Math.max(Math.min(pos.getY(), GameConstants.SCREEN_HEIGHT), 0));

        for(final IPlayerObserver observer: observers){
            observer.setTarget(pos);
        }
        gun.setPlayerPosition(calcGunPos());
    }

    private Point calcGunPos(){
        return new Point(pos.getX() + gunDirection.getX() * GameConstants.PLAYER_RADIUS, pos.getY() + gunDirection.getY() * GameConstants.PLAYER_RADIUS);
    }

    /**
     * Set the mouse position for player
     * @param mousePos the mouse position.
     */

    public void setMousePos(final Point mousePos){
        gunDirection = mousePos.distanceVector(pos);
        if(!gunDirection.isZero()){
            gunDirection = gunDirection.normalized();
        }
    }

    /**
     * Set the gun that is hold by player
     * @param gun the gun hold by player
     */
    public void setGun(final Gun gun){
        this.gun = gun;
    }
    public float getArmourDamageFactor(){
        return armourDamageFactor;
    }
    public void setArmour(final float armourDamageFactor){
        this.armourDamageFactor = armourDamageFactor;
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
        return new Circle(pos, GameConstants.PLAYER_RADIUS);
    }

    /**
     * Collide with another enemy.
     * @param enemy the enemy collided with player
     */
    public void collideWith(final Enemy enemy) {
        takeDamage(enemy.getDamage());
    }

    @Override
    public void collideWith(final Mine mine){
        shield = 0;
        takeDamage(mine.getDamage());
    }

    private void takeDamage(final int damage){
        final float totalHealth = (health + shield) - damage * armourDamageFactor;
        health = Math.round(Math.max(0, Math.min(totalHealth, GameConstants.PLAYER_MAX_HEALTH)));
        shield = Math.round(Math.max(0, Math.min(totalHealth - health, GameConstants.PLAYER_MAX_SHIELD)));
    }
    /**
     * Inform others being collided by player.
     * @param other the object collided with the player
     */
    @Override
    public void informCollision(final ICollidable other) {
        other.collideWith(this);
    }

    public boolean tryToPay(final int priceInGold){
        if(priceInGold > goldOwned){
            return false;
        }

        goldOwned -= priceInGold;
        return true;
    }

    public void addObserver(final IPlayerObserver observer){
        observers.add(observer);
    }


    public int getHealth(){
        return health;
    }
    public int getShield() { return shield; }
    public int getGoldOwned(){return goldOwned;}

    public void addHealth(final int healthToAdd){
        health += healthToAdd;
        health = Math.min(health, GameConstants.PLAYER_MAX_HEALTH);
    }
    public void addGold(final int gold){this.goldOwned += gold;}

    public void addShield(final int shieldToAdd){
        this.shield += shieldToAdd;
    }

}
