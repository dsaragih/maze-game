package g0241.ent;

import g0241.Point;
import g0241.itemData.UsableItemData;

abstract public class ProjectileWeapon extends UsableItemData {
    // This is a projectile weapon that is in the player inventory
    private int amountLoaded;
    public ProjectileWeapon(float damagePerShot, float speedFactor, String typeOfAmmo,
                    int numberOfAvailableUses, g0241.graphics.DrawData image) {
        super(damagePerShot, speedFactor, typeOfAmmo, numberOfAvailableUses, image);
    }
    public void attack(Point vector) {
        if (amountLoaded > 0) {
            --amountLoaded;
            updateNumberOfAvailableUses(-1);
            // new MovingProjectile(Player.x, Player.y, vector);
        }
    }
    public void use() {
        // Vector is a Point instance with the direction of fire
        // attack(vector);
    }
    public void load(int amountToAdd) {
        // This should be called upon collision with some ammo item.
        amountLoaded += amountToAdd;
    }

}
