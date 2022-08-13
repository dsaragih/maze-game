package game.entities.item;

import config.GameConstants;
import game.entities.abstractions.CollidableEntity;
import game.entities.abstractions.Entity;
import game.entities.abstractions.ICollidable;
import game.entities.characters.Player;
import geometry.Circle;
import geometry.Point;
import graphics.entityDrawers.mine.IMineDrawer;

public class Mine extends CollidableEntity {

    private final IMineDrawer mineDrawer;
    private final Entity creator;
    private boolean hasDetonated = false;

    public Mine(final Point pos, final IMineDrawer mineDrawer, final Entity creator) {
        super(pos);
        this.mineDrawer = mineDrawer;
        this.creator = creator;
    }
    public Mine(final int x, final int y, final IMineDrawer mineDrawer, final Entity creator) {
        super(x, y);
        this.mineDrawer = mineDrawer;
        this.creator = creator;
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(pos, GameConstants.MINE_RADIUS);
    }

    @Override
    public void informCollision(final ICollidable other){
        other.collideWith(this);
    }

    @Override
    public void collideWith(final Player player){
        hasDetonated = true;
    }

    @Override
    public boolean shouldBeRemoved(){
        return hasDetonated;
    }

    public static float getMineRadius(){
        return GameConstants.MINE_RADIUS;
    }

    @Override
    public void draw(){
        mineDrawer.drawMine(pos);
    }

    @Override
    public void update(){
        if(creator.shouldBeRemoved()){
            hasDetonated = true;
        }
    }

    public int getDamage() { return GameConstants.MINE_DAMAGE; }

}
