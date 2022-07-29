package com.mygdx.game.Entities.Item;

public class Armour extends Item{
    private int armourPoint;
    public Armour(float x, float y, boolean onGround, float value, int armourPoint) {
        super(x, y, onGround, value);
        this.armourPoint = armourPoint;
    }

    //An armour has armour point that reduce damage
    @Override
    public void draw() {

    }

}
