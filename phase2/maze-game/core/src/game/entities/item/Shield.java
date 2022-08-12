package game.entities.item;

import game.entities.characters.Player;

public class Shield extends Item{

    private int shieldToAdd = 25;

    public Shield(){
        super("Small Shiled", 20);
    }
    @Override
    public void operateOnPlayer(Player player) {
        player.addShield(25);
    }
}
