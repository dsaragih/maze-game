package com.mygdx.game.Entities;

import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.gun.IGunDrawer;

public class Gun extends Entity {

    private IGunDrawer gunDrawer;

    public Gun(Point pos, IGunDrawer gunDrawer){
        super(pos);
        this.gunDrawer = gunDrawer;
    }

    private void fire(Point direction){

    }

    public void setPosition(Point pos){
        this.pos = pos;
    }

    @Override
    public void draw() {
        gunDrawer.drawGun(pos);
    }
}
