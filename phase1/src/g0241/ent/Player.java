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

        cords.setX(cords.getX() + dx);
        cords.setY(cords.getY() + dy);

        if (cords.getX() < 1) {
            cords.setX(0);
        }

        if (cords.getY() < 1) {
            cords.setY(0);
        }
    }
    @Override
    void act() {
        //take WASD commands from keyboard OR moveTo(cursor)
    }
}
