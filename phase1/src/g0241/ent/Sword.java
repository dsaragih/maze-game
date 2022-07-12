package g0241.ent;
import g0241.itemData.ItemData;
import g0241.Point;

public class Sword extends Item{
    public Sword(ItemData itemData, Point cords){
        super(itemData, cords);
    }
    public Sword(ItemData itemData, float x, float y){
        super(itemData, x, y);
    }
    public void act(){
        //
    }
    public void Collidewith(Object other){

    }

    public CollisionBox getCollisionBox(){
        return new CollisionBox(cords);
    }
}
