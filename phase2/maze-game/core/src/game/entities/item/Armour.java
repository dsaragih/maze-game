package game.entities.item;

import game.entities.characters.Player;

public class Armour extends Item{
    private final float armourDamageFactor;
    public Armour(final float armourDamageFactor, final String name, final int price) {
        super(name, price);
        this.armourDamageFactor = armourDamageFactor;
    }

    @Override
    public void operateOnPlayer(final Player player) {
        player.setArmour(armourDamageFactor);
    }
}
