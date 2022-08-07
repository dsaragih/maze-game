package entities.item;

import entities.abstractions.CollidableEntity;
import entities.abstractions.ICollidable;
import entities.characters.Enemy;
import entities.characters.Player;
import geometry.Circle;
import graphics.entities.merchant.IMerchantDrawer;

import java.util.ArrayList;

public class Merchant extends CollidableEntity {
    //A merchant will sell stuff to the player
    private ArrayList<Item> itemOwned;
    private IMerchantDrawer drawer;
    private boolean showMenu = false;
    public Merchant(float x, float y, ArrayList<Item> itemOwned, IMerchantDrawer drawer) {
        super(x, y);
        this.itemOwned = itemOwned;
        this.drawer = drawer;
    }
    public Merchant(float x, float y, IMerchantDrawer drawer){
        super(x,y);
        itemOwned = new ArrayList<>();
        this.drawer= drawer;
    }

    @Override
    public void draw() {
        drawer.drawMerchant(pos);
        if(showMenu){
            drawer.drawItemList(pos, itemOwned);
        }
    }

    @Override
    public void update(){
        showMenu = false;
    }
    @Override
    public Circle getCollisionBox() {
        return new Circle(pos, 15);
    }
    @Override
    public void collideWith(Player player) {
        showMenu = true;
    }
    @Override
    public void informCollision(ICollidable other) {
    other.collideWith(this);
    }
    public ArrayList<Item> getItemOwned(){return itemOwned;}
}
