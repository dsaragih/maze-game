package entities;

import entities.item.Item;
import geometry.Circle;
import geometry.Point;
import graphics.entities.boss.IBossDrawer;

public class Boss extends CollidableEntity implements IPlayerObserver{

    private int health = 1500;
    public Gun gun;
    private Point target = null;

    private IBossDrawer bossDrawer;
    private int radius = 10;
    public Boss(int x, int y, IBossDrawer drawer){
        super(x, y, true);
        bossDrawer = drawer;
    }
    public Boss(Point pos, IBossDrawer drawer){
        super(pos, true);
        bossDrawer = drawer;
    }
    @Override
    public void draw() {
        bossDrawer.drawBoss(pos);
    }
    @Override
    public void update(){
        radius += 1;
//        fire(target);

}
    public void fire(Point direction){
        gun.fire(direction);
    }

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
    public void informCollision(ICollidable other) {other.informCollision(this);
    }

    @Override
    public void collideWith(Merchant merchant) {

    }

    @Override
    public void setTarget(Point newTarget) {
           target = newTarget;
    }
    public void setGun(Gun gun){this.gun = gun;}
}
