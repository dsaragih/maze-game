package g0241.ent;

import g0241.Point;

import java.awt.Image;

public class CollisionBox {

    Point Center;
    public CollisionBox(Point Center){
        this.Center = Center;
    }


    public boolean overlaps(CollisionBox other){
        return true;
    }


}
