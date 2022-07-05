package g0241.ent;

import g0241.Point;

abstract public class Enemy extends Entity{
    int hp, hpmax, xp;
    public Enemy(float x, float y) {
        super(x, y);
    }


    void moveTo(Entity target, float speed){
        float dx = target.cords.getX() - this.cords.getX();
        float dy = target.cords.getY() - this.cords.getX();
        float distance = (float) Math.sqrt(dx*dx + dy*dy);
        if (distance < .0001) return; //already at destination

        float fractionTravelled = Math.max(1, speed / distance);
        dx = dx * fractionTravelled;
        dy = dy * fractionTravelled;
        this.cords.add(new Point(dx,dy));
    }
}
