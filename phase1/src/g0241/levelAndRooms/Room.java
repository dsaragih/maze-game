package g0241.levelAndRooms;

import g0241.Point;
import g0241.ent.DrawableEntity;
import g0241.ent.Entity;
import g0241.graphics.DrawData;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room extends DrawableEntity{
    //The room class should implement drawable, being added to random size and texture. It should keep track of whether
    //if the player is inside the room or not, while the player is inside the room, it should update the player position
    //The room will also spawn item randomly from the available pool.

    //The dimension of the room, the exact default value is indetermined yet (left open for discussion)
    private int width;
    private int height;
    //There is a list keeping track of event on each grid
    private ArrayList<Entity> stuff;

    public Room(int width, int height, ArrayList<Entity> initialEvent){
        super(width,height);
        this.stuff = initialEvent;
    }
    //to be implemented after we are done with the algorithm of generating random room
    public void addItem(Entity item){
        stuff.add(item);
    }
    public void removeItem(Entity item){
        stuff.remove(item);
    }
   // public Point getPlayrrPos(){

    //}


    //A filler, not implemented yet
    public void act(){

    }

    @Override
    public DrawData getDrawdata() {
        return null;
    }
}
