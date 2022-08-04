package com.mygdx.game.Entities;

import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.entities.Boss.IBossDrawer;
import com.mygdx.game.graphics.entities.enemy.IEnemyDrawer;
import com.mygdx.game.graphics.entities.enemy.SquareEnemyDrawer;

public class Boss extends CollidableEntity implements IPlayerObserver{

    private int health = 1500;
    public Gun gun;

    private final IBossDrawer bossDrawer;
    private int radius = 10;
    public Boss(int x, int y, IBossDrawer drawer){
        super(x, y, true);
        bossDrawer = drawer;
    }
    @Override
    public void draw() {
        bossDrawer.drawBoss(pos);
    }
    @Override
    public void update(){
        radius += 1;}

    @Override
    public Circle getCollisionBox() {
        return new Circle(pos, radius);
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
        this.health -= bullet.getDamage();
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

    @Override
    public void setTarget(Point target) {

    }
    public void setGUn(Gun gun){this.gun = gun;}
}
