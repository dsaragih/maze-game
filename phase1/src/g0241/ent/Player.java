package g0241.ent;

public class Player extends Entity{

    public Player(float x, float y) {
        super(x, y);
        r = 8;
        speed = 5;
    }

    @Override
    void act() {
        //take WASD commands from keyboard OR moveTo(cursor)
    }
}
