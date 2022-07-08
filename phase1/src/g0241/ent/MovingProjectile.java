package g0241.ent;
import g0241.Point;
import g0241.graphics.DrawData;

public class MovingProjectile extends DrawableEntity {
    private DrawData drawData;
    private float dx, dy;
    public MovingProjectile(float x, float y, Point vector) {
        super(x, y);
        this.dx = vector.getX();
        this.dy = vector.getY();
    }
    public void act() {}

    public void setDx(float dx) {
        this.dx = dx;
    }
    public void setDy (float dy) { this.dy = dy; }

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
