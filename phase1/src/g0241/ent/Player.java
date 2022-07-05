package g0241.ent;

import java.util.ArrayList;

public class Player extends Entity {
    public float health, xp, dx, dy;
    //public ArrayList<ItemData> inventory;

    public Player(float x, float y) {
        super(x, y);
        health = 100;
        xp = dx = dy = 0;
        //inventory = new ArrayList<ItemData>();
    }

    public void setDx (float dx) {this.dx = dx;}
    public void setDy (float dy) {this.dy = dy;}

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 0;
        }

        if (y < 1) {
            y = 0;
        }
    }
    @Override
    void act() {
        //take WASD commands from keyboard OR moveTo(cursor)
    }
}
