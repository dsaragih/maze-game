package g0241.ent;

import g0241.graphics.DrawData;

public class MovingProjectile extends DrawableEntity {
    private DrawData drawData;
    public float dx, dy;
    public MovingProjectile(float x, float y) {
        super(x, y);
    }
    public void act() {}

    public void move() {
        float x = cords.getX();
        float y = cords.getY();
        updatePos(x + dx, y + dy);
    }

    @Override
    public DrawData getDrawdata() {
        return drawData;
    }
}
