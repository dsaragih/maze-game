package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Circle;

public interface ICollidable {
    public Circle getCollisionBox();
    public void collideWith(Player player);
    public void collideWith(Enemy enemy);
    public void collideWith(Door door);
    public void collideWith(Bullet bullet);
    public void informCollision(ICollidable other);
}
