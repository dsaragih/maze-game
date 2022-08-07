package entities.item;

import entities.abstractions.ICollidable;
import entities.characters.Enemy;
import entities.characters.Player;
import geometry.Circle;
import geometry.Point;


public class Weapon extends Item implements ICollidable {
    private int damage;
    public Weapon(float x, float y, int value, String name, int damage) {
        super(x, y, value, name);
        this.damage = damage;
    }
    public Weapon(Point pos){
        super(pos);
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
    public void collideWith(Item item) {

    }

    @Override
    public void informCollision(ICollidable other) {

    }

    @Override
    public void collideWith(Merchant merchant) {

    }

    public int getDamage(){
        return damage;
    }
}
