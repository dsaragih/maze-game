package com.mygdx.game;

import com.mygdx.game.Entities.CollidableEnitity;
import com.mygdx.game.Entities.Entity;

public interface IRoomEntityManager {
    void addNonCollidableEntity(Entity ent);
    void addCollidableEntity(CollidableEnitity ent);
    void removeNonCollidableEntity(Entity ent);
    void removeCollidableEntity(CollidableEnitity ent);
}
