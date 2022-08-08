package entities.characters;

import com.badlogic.gdx.Gdx;
import config.GameConstants;
import entities.abstractions.CollidableEntity;
import entities.abstractions.ICollidable;
import entities.abstractions.IPlayerObserver;
import entities.item.*;
import graphics.healthbar.IHealthBarDrawer;
import manager.IEntityManager;
import geometry.Circle;
import geometry.Point;
import graphics.entities.player.IPlayerDrawer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Represents the player
 * @author Ian
 * @author Ethan
 * @author Daniel.
 */
public class Player extends CollidableEntity {

    private final int MAX_HEALTH = 100;
    private int health = MAX_HEALTH;
    private IPlayerDrawer playerDrawer;
    private Collection<IPlayerObserver> observers = new ArrayList<>();
    private Point gunDirection = new Point(0,0);
    public Gun gun;

//    private Armour armour;
//    private float armourPoint = 0.0F;
//    private int shield = 0;
//
//    private int goldOwned = 100;
//    private ArrayList<Item> itemOwned = new ArrayList<>(Collections.singletonList(gun));
//    public boolean collideWithMerchant = false;
//
//    private Merchant currMerchant;
//
//    private InventoryManager inventory;

    /**
     * Create a player
     * @param pos The position of player
     * @param playerDrawer The drawer of player
     */
    public Player(Point pos, IPlayerDrawer playerDrawer){
        super(pos);
        this.playerDrawer = playerDrawer;
//        inventory = new InventoryManager(this, itemOwned);
    }

    /**
     * Set up a gun manager for player
     * @param entityManager The manager of the player's guns
     */
    public void setGunEntityManager(IEntityManager entityManager){
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
        //move in the given direction
        direction.multiply(GameConstants.PLAYER_SPEED * Gdx.graphics.getDeltaTime());
        pos.add(direction);

        //keep player on the screen
        pos.x = Math.max(Math.min(pos.x, GameConstants.SCREEN_WIDTH), 0);
        pos.y = Math.max(Math.min(pos.y, GameConstants.SCREEN_HEIGHT), 0);

        for(IPlayerObserver observer: observers){
            observer.setTarget(pos);
        }
        gun.setPlayerPosition(calcGunPos());
    }

    private Point calcGunPos(){
        return new Point(pos.x + gunDirection.x * 10, pos.y + gunDirection.y * 10);
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

//    /**
//     * Set the armour that is wear by player
//     * @param armour the armour wear by player
//     */
//    public void setArmour(Armour armour){
//        if(!itemOwned.contains((armour)))
//        {itemOwned.add(armour);}
//        this.armour = armour;
//        this.shield = armour.getShield();
//        this.armourPoint = armour.getArmourPoint();
//        armour.collideWith(this);
//
//    }

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
    public void collideWith(Enemy enemy) {
//        int totalHealth = health + shield;
//        totalHealth -= enemy.getDamage() *(1.0 - armourPoint * 0.01);
//        health = Math.min(totalHealth, MAX_HEALTH);
//        shield = Math.max(totalHealth - health, 0);

        health = Math.max(health - enemy.getDamage(), 0);
    }

//    @Override
//    public void collideWith(Item item){
//        itemOwned.add(item);
//    }

    /**
     * Inform others being collided by player.
     * @param other the object collided with the player
     */
    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }

//    @Override
//    public void collideWith(Merchant merchant) {
//        collideWithMerchant = true;
//        currMerchant = merchant;
//    }

//    public void buy(Item item){
//        if (!(currMerchant == null)){
//            if (currMerchant.getItemOwned().contains(item) && goldOwned >= item.getValue())
//            {
//                addItem(item);
//                goldOwned -= item.getValue();
//                inventory.addItem(item);
//            }
//        }
//    }

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

//    public void changeGold(int amount){this.goldOwned += amount;}
//
//    public boolean hasCollideWithMerchant(){return collideWithMerchant;}
//
//    public void setCollideWithMerchant(){collideWithMerchant = false;}
//
//    public ArrayList<Item> getItem(){
//        return inventory.getItems();
//    }
//    public void addItem(Item item){inventory.addItem(item);}
//
//    public Merchant getCurrMerchant(){return currMerchant;}

//    public void useArmour(){
//        if (inventory.hasArmour())
//        {
//            inventory.use((Armour) inventory.getArmour());
//            inventory.removeItem(inventory.getArmour());
//        }
//    }
//    public void restoreHealth()
//    {
//        if(inventory.hasHealthFlask()){
//            health += 30;
//            health = Math.min(100, health);
//            inventory.removeItem(inventory.getHealthFlask());
//        }
//    }

}
