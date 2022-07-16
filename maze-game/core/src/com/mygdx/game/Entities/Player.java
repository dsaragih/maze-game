package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.entities.player.IPlayerDrawer;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends CollidableEnitity {
    private float speed = 200;
    private int health = 100;
    private IPlayerDrawer playerDrawer;
    private Collection<IPlayerObserver> observers = new ArrayList<>();

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

        for(IPlayerObserver observer: observers){
            observer.setTarget(pos);
        }
    }

    public void draw(){
        playerDrawer.drawPlayer(pos);
    }

    public Circle getCollisionBox(){
        return new Circle(pos, 10);
    }

    @Override
    public void collideWith(Player player) {

    }


    public void collideWith(Enemy enemy) {
        health -= enemy.getDamage();
    }

    @Override
    public void collideWith(Door door) {

    }

    private int dirCalc(boolean a, boolean b){
        if(a == b){
            return 0;
        }

        return b ? 1 : -1;
    }

    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }

    public void addObserver(IPlayerObserver observer){
        observers.add(observer);
    }
}
