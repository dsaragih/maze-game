package game.entities.abstractions;

import game.entities.item.Mine;
import game.entities.characters.Enemy;
import game.entities.characters.MineDropperEnemy;
import game.entities.characters.Player;
import game.entities.item.Bullet;
import game.entities.item.Door;
import game.entities.item.Item;
import game.entities.characters.Merchant;
import geometry.Circle;
import manager.IEntityManager;
import geometry.Point;

public abstract class CollidableEntity extends Entity implements ICollidable{

    /**
     * Create a collidable entity with the position
     * @param pos position of the entity
     */
    public CollidableEntity(final Point pos) {
        super(pos);
    }

    /**
     * Create a collidable entity with coordinate (x,y)
     * @param x the horizontal coordinate of the entity
     * @param y the vertical coordinate of the entity
     */
    public CollidableEntity(final float x, final float y) {
        super(x, y);
    }
    public CollidableEntity(final Point pos, final boolean needToBeKilled){super(pos, needToBeKilled);}
    public CollidableEntity(final float x, final float y, final boolean needToBeKilled){super(x,y,needToBeKilled);}

    @Override
    public void draw() {

    }

    public abstract Circle getCollisionBox();

    @Override
    public void collideWith(final Player player) {

    }

    @Override
    public void collideWith(final Enemy enemy) {

    }

    @Override
    public void collideWith(final Door door) {

    }

    @Override
    public void collideWith(final Bullet bullet) {

    }

    @Override
    public void collideWith(final Item item) {

    }

    @Override
    public void informCollision(final ICollidable other) {

    }

    @Override
    public void collideWith(final Merchant merchant) {

    }

    @Override
    public void collideWith(final MineDropperEnemy mineDropperEnemy){

    }

    @Override
    public void removeSelf(final IEntityManager entityManager){
        entityManager.removeEntity(this);
    }

    @Override
    public void collideWith(final Mine mine){

    }
}
