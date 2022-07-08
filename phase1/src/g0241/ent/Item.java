package g0241.ent;

import g0241.Interface.Collidable;
import g0241.itemData.ItemData;
import g0241.Point;

abstract public class Item extends Entity implements Collidable{
    public ItemData itemData;
    Point cords;
    public Item(g0241.itemData.ItemData itemData, Point cords){
        super(cords);
        this.itemData = itemData;
    }
    public Item(g0241.itemData.ItemData itemData, float x, float y){
        super(x, y);
        this.itemData = itemData;
    }
    public ItemData pickedUp(){
        return itemData;
    }
    abstract void act();

}

