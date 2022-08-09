
import game.entities.characters.Enemy;
import game.entities.characters.Player;
import game.entities.item.Bullet;
import game.entities.item.ExampleArmour;
import game.entities.characters.Merchant;
import game.entities.item.Item;
import geometry.Point;
import graphics.game.entities.drawers.player.CirclePlayerDrawer;
import graphics.healthbar.HealthBarDrawer;
import manager.EntityManager;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
public class CharactersTest {
    @Test(timeout=50)
    public void MerchantTest(){
        ExampleArmour armour = new ExampleArmour(0,0);
        ArrayList<Item> items = new ArrayList<>();
        items.add(armour);
        Merchant merchant = new Merchant((float)0, (float)0,items, null);
        Player player = new Player(new Point(0,0), null);
        player.collideWith(merchant);
        player.buy(armour);
        player.setArmour(armour);
        assertEquals(player.getShield(), 30);
    }

    @Test(timeout=50)
    public void EnemyTest(){

    }

    @Test(timeout=50)
    public void MineDropperEnemyTest(){

    }

    @Test(timeout=50)
    public void PlayerTest(){

    }

}
