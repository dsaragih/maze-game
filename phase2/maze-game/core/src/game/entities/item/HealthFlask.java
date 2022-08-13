package game.entities.item;

import game.entities.characters.Player;

public class HealthFlask extends Item{
    public HealthFlask(){
        super( "Health Flask", 10);
    }

    @Override
    public void operateOnPlayer(final Player player) {
        player.addHealth(50);
    }
}
