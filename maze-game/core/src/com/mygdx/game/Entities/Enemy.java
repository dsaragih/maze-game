package com.mygdx.game.Entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
public class Enemy extends Entity {
    private Point pos;
    private int radius = 15;
    private float speed = 200;
    private Color color = Color.RED;

    public Enemy(int x, int y, ShapeRenderer shapeRenderer) {
        super(x, y, shapeRenderer);
    }

    public Circle getCollisionBox(){
        return new Circle(pos, radius);
    }

    public void update(Player player) {
        Point dir = pos.separation(player.pos).normalized();
        dir.multiply(speed * Gdx.graphics.getDeltaTime());
        pos.add(dir);
    }
}
