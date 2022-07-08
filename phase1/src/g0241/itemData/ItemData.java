package g0241.itemData;
import g0241.graphics.DrawData;
public class ItemData {
    //    WARNING: JACK WILL DO THIS PART.
//    Represents items that are not entities. All the
//details that the player class needs in order to
//use that item. For example, damage per shot,
//speed factor, type of ammo, image to be
//displayed in inventory, number of available
//uses, etc.
    private final float damagePerShot;
    private final float speedFactor;
    private final String typeOfAmmo;
    private int numberOfAvailableUses;
    private final DrawData image;
    public ItemData(float damagePerShot, float speedFactor, String typeOfAmmo,
                    int numberOfAvailableUses, g0241.graphics.DrawData image){
        this.damagePerShot = damagePerShot;
        this.speedFactor = speedFactor;
        this.typeOfAmmo = typeOfAmmo;
        this.numberOfAvailableUses = numberOfAvailableUses;
        this.image = image;
    }
    public ItemData(int numberOfAvailableUses, g0241.graphics.DrawData image) {
        // Items such as Ammo or Consumable should not have damagePerShot, speedFactor, or typeOfAmmo
        // As a temporary measure, I'll set these values to 0.
        this.numberOfAvailableUses = numberOfAvailableUses;
        this.image = image;
        this.speedFactor = this.damagePerShot = 0;
        this.typeOfAmmo = "";
    }
    public float getDamagePerShot(){
        return damagePerShot;
    }
    public float getSpeedFactor(){
        return speedFactor;
    }
    public String getTypeOfAmmo(){
        return typeOfAmmo;
    }
    public int getNumberOfAvailableUses(){
        return numberOfAvailableUses;
    }
    public g0241.graphics.DrawData getImage(){
        return image;
    }
    public void updateNumberOfAvailableUses(int change) {
        this.numberOfAvailableUses += change;
        if (this.numberOfAvailableUses <= 0) {
            // do something
        }
    }

    // There should be a method that checks if the item has run out of available uses, and somehow
    // disables/deletes the item.
}
