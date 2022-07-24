package com.mygdx.game;

import com.mygdx.game.Entities.CollidableEntity;
import com.mygdx.game.Entities.Entity;

 * Represents an entity manager interface
 * @author Daniel
 * @author Ethan
 * @author Ian
 */
public interface IEntityManager {

    /**
     * Add a non collidable entity to manager
     * @param ent entity being added
     */
    void addNonCollidableEntity(Entity ent);

    /**
     * Add a collidable entity to manager
     * @param ent entity being added
     */
    void addCollidableEntity(CollidableEntity ent);

    /**
     * remove a non-collidable entity from manager
     * @param ent entity being removed
     */
    void removeEntity(Entity ent);

    /**
     * remove a collidable entity from manager
     * @param ent entity being removed
     */
}
