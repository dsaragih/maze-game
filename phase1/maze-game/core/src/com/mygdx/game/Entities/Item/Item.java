package com.mygdx.game.Entities.Item;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.Entities.CollidableEntity;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.ICollidable;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;

public  abstract class Item extends CollidableEntity implements IDrawble {
    //Item is an object that can be pick up by the player, and has a value. This is not a class we write in phase 1
    //An item has a value, a name, and can be picked up or dropped.

    private int value;
    String name;
    public Item(float x, float y, int value, String name) {
        super(x, y);
        this.value = value;
        this.name = name;
    }
    public Item(Point pos, int value, String name){
        super(pos);
        this.value = value;
        this.name = name;
    }
    public Item(Point pos){
        super(pos);
    }

    public Item(float x, float y) {
        super(x,y);
    }

    public abstract void draw();


    public int checkValue(){
        return value;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public void collideWith(Player player){}

    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }

}
