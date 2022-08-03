package com.mygdx.game.Entities.Item;

import com.mygdx.game.Entities.Bullet;
import com.mygdx.game.Entities.Door;
import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Merchant;
import com.mygdx.game.geometry.Circle;

public class HealthFlask extends Item{
    public int healthRestored = 30;
    public HealthFlask(float x, float y){
        super(x,y,8, "Health Flask");
    }

    @Override
    public void draw() {

    }

    @Override
    public Circle getCollisionBox() {
        return null;
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
    public void collideWith(Merchant merchant) {

    }
}
