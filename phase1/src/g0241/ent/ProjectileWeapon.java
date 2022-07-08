package g0241.ent;

import java.util.ArrayList;
import g0241.itemData.ItemData;
import g0241.Point;
import g0241.itemData.UsableItemData;

abstract public class ProjectileWeapon extends UsableItemData {
    // This is a projectile weapon that is in the player inventory
    private int amountLoaded;
    public ProjectileWeapon(float damagePerShot, float speedFactor, String typeOfAmmo,
                    int numberOfAvailableUses, g0241.graphics.DrawData image) {
        super(damagePerShot, speedFactor, typeOfAmmo, numberOfAvailableUses, image);
    }
    public void attack() {
        if (amountLoaded > 0) {
            --amountLoaded;
            updateNumberOfAvailableUses(-1);
        }
    }
    public void use() {attack();}
    public void load(int amountToAdd) {
        // This should be called upon collision with some ammo item.
        amountLoaded += amountToAdd;
    }

}
