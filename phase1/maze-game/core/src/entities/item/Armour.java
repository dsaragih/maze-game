package entities.item;

import entities.abstractions.ICollidable;
import entities.characters.Enemy;
import entities.characters.Player;
import geometry.Circle;
import geometry.Point;

public class Armour extends Item{
    private float armourPoint;
    private int shield;
    public Armour(float x, float y, int value, float armourPoint, String name, int shield) {
        super(x, y, value, name);
        //armour point reduce the damage taken by a percentage
        this.armourPoint = Math.min(99, armourPoint);
        //shield take certain amount of damage
        this.shield = shield;
    }
    public Armour(Point pos){
        super(pos);
    }
    public Armour(Point pos, int value, float armourPoint, int shield, String name) {
        super(pos, value, name);
        //armour point reduce the damage taken by a percentage
        this.armourPoint = Math.min(99, armourPoint);
        //shield take certain amount of damage
        this.shield = shield;
    }

    public Armour(float x, float y, int value, float armourPoint, int shield, String name) {
        super(x, y, value, name);
        //armour point reduce the damage taken by a percentage
        this.armourPoint = Math.min(99, armourPoint);
        //shield take certain amount of damage
        this.shield = shield;
    }

    public Armour(float x, float y) {
        super(x,y);
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
    public void collideWith(Item item) {

    }

    @Override
    public void informCollision(ICollidable other) {

    }

    @Override
    public void collideWith(Merchant merchant) {

    }

    public int getShield(){return shield;}
    public float getArmourPoint(){return armourPoint;}
}
