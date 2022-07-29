package com.mygdx.game.Entities.Item;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;

public  abstract class Item extends Entity implements IDrawble {
    //Item is an object that can be pick up by the player, and has a value. This is not a class we write in phase 1
    private boolean onGround;
    private float value;
    public Item(float x, float y, boolean onGround, float value) {
        super(x, y);
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

}
