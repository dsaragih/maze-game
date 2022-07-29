package com.mygdx.game.Entities.Item;

import com.mygdx.game.Entities.*;
import com.mygdx.game.geometry.Circle;

public class Weapon extends Item implements ICollidable {
    private int damage;
    public Weapon(float x, float y, boolean onGround, float value, int damage) {
        super(x, y, onGround, value);
        this.damage = damage;
    }

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
