package com.mygdx.game;

import com.mygdx.game.Entities.*;
import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.graphics.IDrawble;
import com.mygdx.game.graphics.entities.Merchant.CircleMerchantDrawer;
import com.mygdx.game.graphics.entities.Merchant.IMerchantDrawer;

import java.util.ArrayList;

public class Merchant extends CollidableEntity implements IDrawble {
    //A merchant will sell stuff to the player
    private ArrayList itemOwned;
    private IMerchantDrawer drawer;
    public Merchant(float x, float y, ArrayList itemOwned, IMerchantDrawer drawer) {
        super(x, y);
        this.itemOwned =itemOwned;
        this.drawer = drawer;
    }
    public Merchant(float x, float y, IMerchantDrawer drawer){
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
//        int screenWidth = 960;
//        int screenHeight = 540;
//        com.mygdx.game.geometry.Point pos = new com.mygdx.game.geometry.Point(960, 540);
//        drawer.drawItemList(pos, itemOwned);
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
    other.collideWith(this);
    }

    @Override
    public void collideWith(Merchant merchant) {

    }
}
