package com.mygdx.game.Entities.Item;

import com.mygdx.game.geometry.Point;

public class Armour extends Item{
    private float armourPoint;
    private int shield;
    public Armour(float x, float y, boolean onGround, float value, float armourPoint, int shield) {
        super(x, y, onGround, value);
        //armour point reduce the damage taken by a percentage
        this.armourPoint = Math.min(99, armourPoint);
        //shield take certain amount of damage
        this.shield = shield;
    }
    public Armour(Point pos){
        super(pos);
    }



    //An armour has armour point that reduce damage
    @Override
    public void draw() {

    }

}
