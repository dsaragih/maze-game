package entities.item;

import entities.Bullet;
import entities.Door;
import entities.Enemy;
import entities.Merchant;
import geometry.Circle;

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
