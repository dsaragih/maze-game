package g0241.ent;
import g0241.Point;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
abstract public class Entity {
    Point cords;

    public Entity(float x, float y) {
        cords = new Point(x,y);
    }

    public Entity(Point cords) {
        this.cords = cords;
    }

    // written for the Room class

    public Entity(int x, int y){cords = new Point(x,y);}

    abstract void act();



}
