package com.mygdx.game;

import com.mygdx.game.Entities.CollidableEntity;
import com.mygdx.game.Entities.Entity;

public interface IRoomEntityManager {
    void addNonCollidableEntity(Entity ent);
    void addCollidableEntity(CollidableEntity ent);
    void removeNonCollidableEntity(Entity ent);
    void removeCollidableEntity(CollidableEntity ent);
}
