package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 pos;
    private int radius = 10;
    private float speed = 200;

    ShapeRenderer shapeRenderer;

    public Player(int x, int y, ShapeRenderer shapeRenderer){
        pos = new Vector2(x, y);
        this.shapeRenderer = shapeRenderer;
    }
    public void update(){
        Vector2 dir = new Vector2(0,0);
        dir.x = dirCalc(Gdx.input.isKeyPressed(Input.Keys.A), Gdx.input.isKeyPressed(Input.Keys.D));
        dir.y = dirCalc(Gdx.input.isKeyPressed(Input.Keys.S), Gdx.input.isKeyPressed(Input.Keys.W));
        pos = add(pos, multiply(dir, speed * Gdx.graphics.getDeltaTime()));
    }

    public void draw(){
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(pos.x, pos.y, radius);
        shapeRenderer.end();
    }

    private int dirCalc(boolean a, boolean b){
        if(a == b){
            return 0;
        }

        return b ? 1 : -1;
    }

    private Vector2 add(Vector2 v1, Vector2 v2){
        return new Vector2(v1.x + v2.x , v1.y + v2.y);
    }

    private Vector2 multiply(Vector2 v1, float scalar){
        return new Vector2(v1.x * scalar , v1.y * scalar);
    }
}
