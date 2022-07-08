package g0241.ent;

import g0241.itemData.ItemData;

public class Ammo extends Item {
    public Ammo(ItemData itemData, g0241.Point coords) {
        super(itemData, coords);
    }
    public Ammo (int amount, g0241.graphics.DrawData image, g0241.Point coords) {
        super(new ItemData(amount, image), coords);
    }
    @Override
    public ItemData pickedUp() {
        // If we have a projectile weapon that uses this ammo, then add it directly to the weapon,
        // Else, add it to the inventory
        return itemData;
    }

    public void act() {}

    @Override
    public void Collidewith(Object other) {
        // I don't know what this does
    }

    @Override
    public CollisionBox getCollisionBox() {
        return null;
    }
}
