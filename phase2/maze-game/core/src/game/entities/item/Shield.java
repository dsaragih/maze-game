package game.entities.item;

import config.GameConstants;
import game.entities.characters.Player;

public class Shield extends Item {

    public Shield(){
        super("Small Shield", 20);
    }
    @Override
    public void operateOnPlayer(Player player) {
        player.addShield(GameConstants.SHIELD_NORMAL);
    }
}
