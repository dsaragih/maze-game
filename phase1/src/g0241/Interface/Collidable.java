package g0241.Interface;

import g0241.ent.CollisionBox;

public interface Collidable <T>{

    public void Collidewith(T other);

    public CollisionBox getCollisionBox();
}
