package com.mygdx.game.Entities.Item;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.Entities.CollidableEntity;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;

public  abstract class Item extends CollidableEntity implements IDrawble {
    //Item is an object that can be pick up by the player, and has a value. This is not a class we write in phase 1
    //An item has a value, a name, and can be picked up or dropped.
    private boolean onGround;
    private float value;
    private String name;
    public Item(float x, float y, boolean onGround, float value, String name) {
        super(x, y);
        this.onGround = onGround;
        this.value = value;
        this.name = name;
    }
    public Item(Point pos, boolean onGround, float value){
        super(pos);
        this.onGround = onGround;
        this.value = value;
    }
    public Item(Point pos){
        super(pos);
    }
    public abstract void draw();

    public float checkValue(){
        return value;
    }

    public void pickUp(){
        onGround = false;
    }
    public  void drop(){
        onGround = true;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public void collideWith(Player player){onGround = false;}

}
