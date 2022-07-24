package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Point;

/**
 * Represents the player observer
 * @author Ethan
 */
public interface IPlayerObserver {

    /**
     * Set the target
     * @param target the target of observer.
     */
    public void setTarget(Point target);

}
