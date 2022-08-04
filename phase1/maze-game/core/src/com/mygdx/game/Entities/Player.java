package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Entities.Item.Armour;
import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.IEntityManager;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.entities.player.IPlayerDrawer;

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
    private final float speed = 200;
    private int health = 100;
    private final IPlayerDrawer playerDrawer;
    private final Collection<IPlayerObserver> observers = new ArrayList<>();
    private Point gunDirection = new Point(0,0);
    public Gun gun;

    private Armour armour;
    private float armourPoint = 0.0F;
    private int shield = 0;

    private int goldOwned = 100;
    private ArrayList<Item> itemOwned = new ArrayList<Item>(Collections.singletonList(gun));

    public boolean collideWithMerchant = false;

    private Merchant currMerchant;

    private InventoryManager inventory;

    /**
     * Create a player
     * @param pos The position of player
     * @param playerDrawer The drawer of player
     */
    public Player(Point pos, IPlayerDrawer playerDrawer){
        super(pos);
        this.playerDrawer = playerDrawer;
        inventory = new InventoryManager(this, itemOwned);
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

        direction.multiply(speed * Gdx.graphics.getDeltaTime());
        //Don't allow the player to get out of the screen
        if(pos.x > 960 && direction.x > 0){
            direction.x = 0;
        }
        if(pos.y > 540 && direction.y > 0){
            direction.y = 0;
        }
        if(pos.x < 0 && direction.x < 0){
            direction.x = 0;
        }
        if(pos.y < 0 && direction.y <0){
            direction.y = 0;
        }
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
        if(!itemOwned.contains(gun))
        {itemOwned.add(gun);}
        this.gun = gun;
    }

    /**
     * Set the armour that is wear by player
     * @param armour the armour wear by player
     */
    public void setArmour(Armour armour){
        if(!itemOwned.contains((armour)))
        {itemOwned.add(armour);}
        this.armour = armour;
        this.shield = armour.getShield();
        this.armourPoint = armour.getArmourPoint();
        armour.collideWith(this);

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
        if(shield > 0){
            if (shield - enemy.getDamage() < 0)
            {health += shield - enemy.getDamage();
            shield = 0;}
        else
            {shield -= enemy.getDamage() * (1.0 - armourPoint * 0.01);}}
        else{health -= enemy.getDamage() *(1.0 - armourPoint * 0.01);}
    }

    /**
     * Collide with another door.
     * @param door the door collided with player
     */
    @Override
    public void collideWith(Door door) {

    }
    @Override
    public void collideWith(Item item){
        itemOwned.add(item);
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

    @Override
    public void collideWith(Merchant merchant) {
        collideWithMerchant = true;
        currMerchant = merchant;
    }

    public void buy(Item item){
        if (!(currMerchant == null)){
            if (currMerchant.getItemOwned().contains(item) && goldOwned >= item.checkValue())
            {addItem(item);
            goldOwned -= item.checkValue();
            inventory.addItem(item);}
        }
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
    public int getGold(){return goldOwned;}

    public int getShield(){return shield;}

    public void changeGold(int amount){this.goldOwned += amount;}

    public boolean hasCollidewithMerchant(){return collideWithMerchant;}

    public void setCollideWithMerchant(){collideWithMerchant = false;}

    public void addItem(Item item){itemOwned.add(item);}

    public Merchant getCurrMerchant(){return currMerchant;}

    public void useArmour(){
        if (inventory.hasArmour()){
            inventory.use((Armour) inventory.getArmour());
            inventory.removeItem(inventory.getArmour());}
    }
    public void restoreHealth(){
        if(inventory.hasHealthFlask()){
            health += 30;
            health = Math.min(100, health);
            inventory.removeItem(inventory.getHealthFlask());
        }
    }
}
