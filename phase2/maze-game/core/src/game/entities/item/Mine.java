package game.entities.item;

import game.entities.abstractions.CollidableEntity;
import game.entities.abstractions.ICollidable;
import game.entities.characters.Player;
import geometry.Circle;
import geometry.Point;
import graphics.game.entities.drawers.Mine.IMineDrawer;

public class Mine extends CollidableEntity {

    private IMineDrawer mineDrawer;
    private static float mineRadius = 10;
    private boolean hasDetonated = false;

    public Mine(Point pos, IMineDrawer mineDrawer) {
        super(pos);
        this.mineDrawer = mineDrawer;
    }

    @Override
    public Circle getCollisionBox() {
        return new Circle(pos, mineRadius);
    }

    @Override
    public void informCollision(ICollidable other){
        other.collideWith(this);
    }

    @Override
    public void collideWith(Player player){
        hasDetonated = true;
    }

    @Override
    public boolean shouldBeRemoved(){
        return hasDetonated;
    }

    public static float getMineRadius(){
        return mineRadius;
    }

    @Override
    public void draw(){
        mineDrawer.drawMine(pos);
    }
}
