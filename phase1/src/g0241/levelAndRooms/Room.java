package g0241.levelAndRooms;

import g0241.Point;
import g0241.ent.DrawableEntity;
import g0241.graphics.DrawData;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room extends DrawableEntity{
    //The room class should implement drawable, being add to random size and texture. It should keep track of whether
    //if the player is inside the room or not, while the player is inside the room, it should update the player position

    //The exact default value is indetermined yet (left open for discussion)
    private int width;
    private int height;
    private ArrayList pos;
    private boolean playerInRoom = false;

    public Room(int width, int height){
        super(width,height);
    }

    //A filler, not implemented yet
    public void act(){

    }

    @Override
    public DrawData getDrawdata() {
        return null;
    }
}
