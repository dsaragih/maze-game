package g0241.itemData;

public class ItemData {
    //    WARNING: JACK WILL DO THIS PART.
//    Represents items that are not entities. All the
//details that the player class needs in order to
//use that item. For example, damage per shot,
//speed factor, type of ammo, image to be
//displayed in inventory, number of available
//uses, etc.
    private float damagePerShot, speedFactor;
    private String typeOfAmmo;
    private int numberOfAvailableUses;
    private g0241.graphics.DrawData image;
    public ItemData(float damagePerShot, float speedFactor, String typeOfAmmo,
                    int numberOfAvailableUses, g0241.graphics.DrawData image){
        this.damagePerShot = damagePerShot;
        this.speedFactor = speedFactor;
        this.typeOfAmmo = typeOfAmmo;
        this.numberOfAvailableUses = numberOfAvailableUses;
        this.image = image;
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
}
