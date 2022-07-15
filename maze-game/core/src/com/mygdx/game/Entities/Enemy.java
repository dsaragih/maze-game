package com.mygdx.game.Entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.entities.IEntityDrawer;

public class Enemy extends Entity {
    private float speed;

    public Enemy(int x, int y, IEntityDrawer entityDrawer) {
        super(x, y, entityDrawer);
        color = Color.RED;
        radius = 15;
        speed = 150;
    }

    public Circle getCollisionBox(){
        return new Circle(pos, radius);
    }

    public void update(Player player) {
        Point dir = pos.separation(player.pos).normalized();
        dir.multiply(-speed * Gdx.graphics.getDeltaTime());
        pos.add(dir);
    }
}
