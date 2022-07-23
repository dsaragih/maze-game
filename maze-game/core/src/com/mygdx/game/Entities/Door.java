package com.mygdx.game.Entities;

import com.mygdx.game.IRoomContainer;
import com.mygdx.game.Room;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.door.IDoorDrawer;

public class Door extends CollidableEntity {

    public Room room;
    public Door door;
    private final IDoorDrawer doorDrawer;
    private final IRoomContainer roomContainer;
    public  Door(Point pos, IDoorDrawer doorDrawer, IRoomContainer roomContainer){
        super(pos);
        this.doorDrawer = doorDrawer;
        this.roomContainer = roomContainer;
    }

    public void setCorrespondingDoor(Door door){
        this.door = door;
    }

    public void setRoom(Room room){
        this.room = room;
    }
    public void draw(){
        doorDrawer.drawDoor(pos);
    }

    public Circle getCollisionBox(){
        return new Circle(pos, 10);
    }


    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }

    public void collideWith(Player player){
        roomContainer.setNewRoom(door.room);
    }

    @Override
    public void collideWith(Enemy enemy) {

    }

    @Override
    public void collideWith(Door door) {

    }

    @Override
    public void collideWith(Bullet bullet) {

    }
}


