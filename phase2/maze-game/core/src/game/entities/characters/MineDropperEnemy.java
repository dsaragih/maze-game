package game.entities.characters;

import com.badlogic.gdx.math.MathUtils;
import config.GameConstants;
import game.entities.item.Mine;
import game.entities.abstractions.CollidableEntity;
import game.entities.abstractions.ICollidable;
import game.entities.item.Bullet;
import geometry.Circle;
import geometry.Point;
import graphics.entityDrawers.mine.IMineDrawer;
import graphics.entityDrawers.mineDropperEnemy.IMineDropperDrawer;
import manager.IEntityManager;

public class MineDropperEnemy extends CollidableEntity {
    private final IMineDropperDrawer mineDropperDrawer;
    private final IMineDrawer mineDrawer;
    private IEntityManager entityManager;
    private Point targetPoint;
    private float health = GameConstants.MINE_DROPPER_MAX_HEALTH;

    private final int value = MathUtils.random(3,6);

    public MineDropperEnemy(final Point pos, final IMineDropperDrawer mineDropperDrawer, final IMineDrawer mineDrawer) {
        super(pos, true);
        targetPoint = getNewTargetPoint();
        this.mineDropperDrawer = mineDropperDrawer;
        this.mineDrawer = mineDrawer;
    }

    public void setEntityManager(final IEntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(pos, GameConstants.MINE_DROPPER_RADIUS);
    }

    @Override
    public void informCollision(final ICollidable other){
        other.collideWith(this);
    }

    @Override
    public void collideWith(final Bullet bullet){
        health -= bullet.getDamage();
    }

    @Override
    public boolean shouldBeRemoved(){
        return health <= 0;
    }

    @Override
    public void update(){
        final float dist = pos.distanceVector(targetPoint).length();
        if(dist < GameConstants.MINE_DROPPER_SPEED){
            pos = targetPoint;
            entityManager.addCollidableEntity(new Mine(pos.clonePoint(), mineDrawer, this));
            targetPoint = getNewTargetPoint();
        }else{
            final Point dir = pos.distanceVector(targetPoint).normalized();
            dir.multiply(-GameConstants.MINE_DROPPER_SPEED);
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
    public int getValue(){return value;}

}
