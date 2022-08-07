package entities.item;

import entities.characters.Enemy;
import geometry.Circle;

public class HealthFlask extends Item{
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
