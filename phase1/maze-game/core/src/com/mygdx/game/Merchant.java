package com.mygdx.game;

import com.mygdx.game.Entities.*;
import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.graphics.IDrawble;
import com.mygdx.game.graphics.Merchant.CircleMerchantDrawer;

import java.util.ArrayList;

public class Merchant extends CollidableEntity implements IDrawble {
    //A merchant will sell stuff to the player
    private ArrayList itemOwned;
    private CircleMerchantDrawer drawer;
    public Merchant(float x, float y, ArrayList itemOwned, CircleMerchantDrawer drawer) {
        super(x, y);
        this.itemOwned =itemOwned;
        this.drawer = drawer;
    }
    public Merchant(float x, float y, CircleMerchantDrawer drawer){
        super(x,y);
        itemOwned = new ArrayList<>();
        this.drawer =drawer;
    }

    @Override
    public void draw() {
        drawer.drawMerchant(pos);
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(pos, 12);
    }

    @Override
    public void collideWith(Player player) {

    }

    @Override
    public void collideWith(Enemy enemy) {

    }

    @Override
    public void collideWith(Door door) {

    }

    @Override
    public void collideWith(Bullet bullet) {

    }

    @Override
    public void collideWith(Item item) {

    }

    @Override
    public void informCollision(ICollidable other) {

    }
}
