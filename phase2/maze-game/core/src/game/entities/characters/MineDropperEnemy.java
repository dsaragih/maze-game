package game.entities.characters;

import com.badlogic.gdx.math.MathUtils;
import config.GameConstants;
import game.entities.item.Mine;
import game.entities.abstractions.CollidableEntity;
import game.entities.abstractions.ICollidable;
import game.entities.item.Bullet;
import geometry.Circle;
import geometry.Point;
import graphics.game.entities.drawers.Mine.IMineDrawer;
import graphics.game.entities.drawers.MineDropperEnemy.IMineDropperDrawer;
import manager.IEntityManager;

public class MineDropperEnemy extends CollidableEntity {
    private IMineDropperDrawer mineDropperDrawer;
    private IMineDrawer mineDrawer;
    private IEntityManager entityManager;
    private Point targetPoint;
    private float speed = 2;
    private float health = 500;

    public MineDropperEnemy(Point pos, IMineDropperDrawer mineDropperDrawer, IMineDrawer mineDrawer) {
        super(pos);
        targetPoint = getNewTargetPoint();
        this.mineDropperDrawer = mineDropperDrawer;
        this.mineDrawer = mineDrawer;
    }

    public void setEntityManager(IEntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(pos, 30);
    }

    @Override
    public void informCollision(ICollidable other){
        other.collideWith(this);
    }

    @Override
    public void collideWith(Bullet bullet){
        health -= bullet.getDamage();
    }

    @Override
    public boolean shouldBeRemoved(){
        return health <= 0;
    }

    @Override
    public void update(){
        float dist = pos.distanceVector(targetPoint).length();
        if(dist < speed){
            pos = targetPoint;
            entityManager.addCollidableEntity(new Mine(pos.clone(), mineDrawer));
            targetPoint = getNewTargetPoint();
        }else{
            Point dir = pos.distanceVector(targetPoint).normalized();
            dir.multiply(-speed);
            pos.add(dir);
        }
    }

    private Point getNewTargetPoint(){
        return new Point(MathUtils.random(Mine.getMineRadius()/2, GameConstants.SCREEN_WIDTH - Mine.getMineRadius()/2),
                MathUtils.random(Mine.getMineRadius()/2, GameConstants.SCREEN_HEIGHT - Mine.getMineRadius()/2));
    }

    @Override
    public void draw(){
        mineDropperDrawer.drawMineDropper(pos);
    }

}
