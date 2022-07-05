package g0241.ent;

import java.util.ArrayList;

public class Player extends Entity {
    public float health, xp;
    //public ArrayList<ItemData> inventory;

    public Player(float x, float y) {
        super(x, y);
        health = 100;
        xp = 0;
        //inventory = new ArrayList<ItemData>();
    }

    @Override
    void act() {
        //take WASD commands from keyboard OR moveTo(cursor)
    }
}
