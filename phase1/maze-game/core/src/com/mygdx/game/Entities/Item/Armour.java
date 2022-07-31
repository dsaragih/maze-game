package com.mygdx.game.Entities.Item;

import com.mygdx.game.Entities.*;
import com.mygdx.game.geometry.Circle;
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
    public Armour(Point pos, boolean onGround, float value, float armourPoint, int shield) {
        super(pos, onGround, value);
        //armour point reduce the damage taken by a percentage
        this.armourPoint = Math.min(99, armourPoint);
        //shield take certain amount of damage
        this.shield = shield;
    }



    //An armour has armour point that reduce damage
    @Override
    public void draw() {

    }

    @Override
    public Circle getCollisionBox() {
        return null;
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
    public void informCollision(ICollidable other) {

    }
}
