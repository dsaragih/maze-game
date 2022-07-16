package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.player.IPlayerDrawer;

public class Player extends Entity{
    private float speed = 200;
    private IPlayerDrawer playerDrawer;

    public Player(Point pos, IPlayerDrawer playerDrawer){
        super(pos);
        this.playerDrawer = playerDrawer;
    }
    public void update(){
        Point dir = new Point(0,0);
        dir.x = dirCalc(Gdx.input.isKeyPressed(Input.Keys.A), Gdx.input.isKeyPressed(Input.Keys.D));
        dir.y = dirCalc(Gdx.input.isKeyPressed(Input.Keys.S), Gdx.input.isKeyPressed(Input.Keys.W));
        dir.multiply(speed * Gdx.graphics.getDeltaTime());
        pos.add(dir);
    }

    public void draw(){
        playerDrawer.drawPlayer(pos);
    }

    public Circle getCollisionBox(){
        return new Circle(pos, 10);
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
