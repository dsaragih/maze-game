package g0241.ent;

abstract public class Entity {
    float x, y, r, speed;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    void moveTo(Entity target){
        float dx = target.x - x;
        float dy = target.y - y;
        float distance = (float) Math.sqrt(dx*dx + dy*dy);
        if (distance < .0001) return; //already at destination
        float fractionTravelled = Math.max(1, speed / distance);
        dx = dx * fractionTravelled;
        dy = dy * fractionTravelled;
        x = x + dx;
        y = y + dy;
    }

    abstract void act();
}
