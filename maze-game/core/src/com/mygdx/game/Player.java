package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Point pos;
    private int radius = 20;
    private float speed = 200;

    public Player(int x, int y, ShapeRenderer shapeRenderer){
        pos = new Point(x, y);
    }
    public void update(){
        Point dir = new Point(0,0);
        dir.x = dirCalc(Gdx.input.isKeyPressed(Input.Keys.A), Gdx.input.isKeyPressed(Input.Keys.D));
        dir.y = dirCalc(Gdx.input.isKeyPressed(Input.Keys.S), Gdx.input.isKeyPressed(Input.Keys.W));
        pos = add(pos, multiply(dir, speed * Gdx.graphics.getDeltaTime()));
    }

    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }

    public Circle getCollisionBox(){
        return new Circle(pos, radius);
    }

    private int dirCalc(boolean a, boolean b){
        if(a == b){
            return 0;
        }

        return b ? 1 : -1;
    }

    private Point add(Point v1, Point v2){
        return new Point(v1.x + v2.x , v1.y + v2.y);
    }

    private Point multiply(Point v1, float scalar){
        return new Point(v1.x * scalar , v1.y * scalar);
    }
}
