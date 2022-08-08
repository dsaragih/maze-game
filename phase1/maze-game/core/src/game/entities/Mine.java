package game.entities;

import game.entities.abstractions.CollidableEntity;
import geometry.Circle;
import geometry.Point;

public class Mine extends CollidableEntity {
    public Mine(Point pos) {
        super(pos);
    }

    @Override
    public Circle getCollisionBox() {
        return null;
    }
}
