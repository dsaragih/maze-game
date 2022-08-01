package com.mygdx.game;

import com.mygdx.game.Entities.*;
import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.graphics.IDrawble;

import java.util.ArrayList;

public class Merchant extends CollidableEntity implements IDrawble {
    //A merchant will sell stuff to the player
    private ArrayList<Item> itemOwned;
    public Merchant(float x, float y, ArrayList itemOwned) {
        super(x, y);
        this.itemOwned =itemOwned;
    }
    public Merchant(float x, float y){
        super(x,y);
        itemOwned = new ArrayList<>();
    }

    @Override
    public void draw() {

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
