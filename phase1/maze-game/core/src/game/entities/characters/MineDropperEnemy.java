package game.entities.characters;

import game.entities.abstractions.CollidableEntity;
import game.entities.abstractions.ICollidable;
import geometry.Circle;
import geometry.Point;
import graphics.game.entities.drawers.enemy.IEnemyDrawer;
import manager.IEntityManager;

public class MineDropperEnemy extends CollidableEntity {
    private IEntityManager entityManager;

    public MineDropperEnemy(Point pos) {
        super(pos);
    }

    public void SetEntityManager(IEntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Circle getCollisionBox() {
        return null;
    }

    @Override
    public void informCollision(ICollidable other){
        other.collideWith(this);
    }

    @Override
    public void update(){

    }
}
