package g0241.ent;

public interface Collidable <T>{

    public void Collidewith(T other);

    public CollisionBox getCollisionBox();
}
