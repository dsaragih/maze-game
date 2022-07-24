package com.mygdx.game;

import com.mygdx.game.Entities.CollidableEntity;
import com.mygdx.game.Entities.Entity;

public interface IEntityManager {
    void addNonCollidableEntity(Entity ent);
    void addCollidableEntity(CollidableEntity ent);
    void removeEntity(Entity ent);
}
