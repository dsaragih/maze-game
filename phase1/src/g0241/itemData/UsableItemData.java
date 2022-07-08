package g0241.itemData;

abstract public class UsableItemData extends ItemData {
    public UsableItemData(float damagePerShot, float speedFactor, String typeOfAmmo,
                    int numberOfAvailableUses, g0241.graphics.DrawData image){
        super(damagePerShot, speedFactor, typeOfAmmo, numberOfAvailableUses, image);
    }
    abstract public void use();
}
