package game.entities.characters;

import com.badlogic.gdx.Gdx;
import config.GameConstants;
import game.entities.item.Mine;
import game.entities.abstractions.CollidableEntity;
import game.entities.abstractions.ICollidable;
import game.entities.abstractions.IPlayerObserver;
import game.entities.item.Armour;
import game.entities.item.Gun;
import game.entities.item.HealthFlask;
import game.entities.item.Item;
import manager.IEntityManager;
import geometry.Circle;
import geometry.Point;
import graphics.entityDrawers.player.IPlayerDrawer;

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

    private int MAX_HEALTH = 100;
    private int health = MAX_HEALTH;
    private IPlayerDrawer playerDrawer;
    private Collection<IPlayerObserver> observers = new ArrayList<>();
    private Point gunDirection = new Point(0,0);
    private Gun gun;
    private float armourPoint = 0.0F;
    private int shield = 0;

    private int goldOwned = 0;
//    public ArrayList<Item> itemOwned = new ArrayList<>(Collections.singletonList(gun));
    private ArrayList<Item> itemOwned = new ArrayList<>();
//
    private Merchant currMerchant;

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
    public void setGunEntityManager(IEntityManager entityManager){
        gun.setEntityManager(entityManager);
    }

    /**
     * Set player's attack direction
     * @param direction The direction of player
     */
    public void fire(Point direction){
        currMerchant = null;
        gun.fire(direction);
    }

    /**
     * Set player's move direction
     * @param direction The direction of player
     */
    public void move(Point direction){
        currMerchant = null;
        //move in the given direction
        direction.multiply(GameConstants.PLAYER_SPEED * Gdx.graphics.getDeltaTime());
        pos.add(direction);

        //keep player on the screen
        pos.setX(Math.max(Math.min(pos.getX(), GameConstants.SCREEN_WIDTH), 0));
        pos.setY(Math.max(Math.min(pos.getY(), GameConstants.SCREEN_HEIGHT), 0));

        for(IPlayerObserver observer: observers){
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
        currMerchant = null;
        this.gun = gun;
    }

    /**
     * Set the armour that is wear by player
     * @param armour the armour wear by player
     */
    public void setArmour(Armour armour){
        this.shield = armour.getShield();
        this.armourPoint = armour.getArmourPoint();
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
    public void collideWith(Enemy enemy) {
        if (enemy.getDamage() * armourPoint * 0.01 >= shield) {
            this.health -= enemy.getDamage() - shield;
            this.shield = 0;
            this.armourPoint = 0;
        } else {
            this.shield = (int) Math.max(this.shield - enemy.getDamage() * armourPoint * 0.01, 0.0);
            this.health -= (int) (enemy.getDamage() * (100. - armourPoint) * 0.01);
        }
        health = Math.max(health, 0);
    }

    @Override
    public void collideWith(Item item){
        itemOwned.add(item);
    }
    @Override
    public void collideWith(Merchant merchant) {
        currMerchant = merchant;
    }

    @Override
    public void collideWith(Mine mine){
        health -= mine.getDamage();
        shield = 0;
    }

    /**
     * Inform others being collided by player.
     * @param other the object collided with the player
     */
    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }
    public ArrayList<Item> getItemOwned(){
        return itemOwned;
    }

    public void buy(Item item){

        if ((currMerchant.getItemOwned().contains(item)) && (goldOwned >= item.getValue()))
        {itemOwned.add(item);
        goldOwned -= item.getValue();}
//        Item wantToBuy = currMerchant.sellItem(item, goldOwned);
//        if (wantToBuy!=null){
//            addItem(wantToBuy);
//            goldOwned -= item.getValue();
//        }
    }

    public void addObserver(IPlayerObserver observer){
        observers.add(observer);
    }


    public int getHealth(){
        return health;
    }
    public int getShield() { return shield; }
    public int getGoldOwned(){return goldOwned;}
    public boolean hasCollideWithMerchant(){return currMerchant!=null;}

    public void resetCollideWithMerchant(){currMerchant = null;}

    public void addItem(Item item){itemOwned.add(item);}
//
    public Merchant getCurrMerchant(){
        return currMerchant;
    }

    public void useArmour(){
        Item toBeRemoved = null;
        for (Item i: itemOwned){
            if (i instanceof Armour){
                toBeRemoved = i;
                Armour armour = (Armour)i;
                setArmour(armour);
            }
        }
        itemOwned.remove(toBeRemoved);
    }
    public void restoreHealth()
    {
        Item toBeRemoved = null;
        for (Item i: itemOwned){
            if(i instanceof HealthFlask){
                health = Math.min(100, health+30);
                toBeRemoved = i;
                break;
            }
        }
        itemOwned.remove(toBeRemoved);

    }
    public void addGold(int gold){this.goldOwned += gold;}

}
