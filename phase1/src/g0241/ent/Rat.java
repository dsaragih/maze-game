package g0241.ent;

public class Rat extends Enemy{

    public Rat(float x, float y) {
        super(x, y);
        hp = hpmax = 1;
        xp = 100;
    }

    @Override
    void act() {
        // moveTo(thePlayer); how to find/pass player's position here?
    }


}
