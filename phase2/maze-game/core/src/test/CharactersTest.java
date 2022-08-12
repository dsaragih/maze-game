
import game.entities.characters.Enemy;
import game.entities.characters.Player;
import game.entities.item.*;
import game.entities.characters.Merchant;
import geometry.Point;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
public class CharactersTest {
    @Test
    public void MerchantTransactionTest(){
//        HealthFlask flask = new HealthFlask(0,0);
//        ArrayList<Item> items = new ArrayList<>();
//        items.add(flask);
//        Merchant merchant = new Merchant((float)0, (float)0,items, null);
//        assertTrue(merchant.getItemOwned().contains(flask));
//        Player player = new Player(new Point(0,0), null);
//        player.addGold(100);
//        player.collideWith(merchant);
//        player.buy(flask);
//        assertEquals(player.getItemOwned().size(),2);
//        assertEquals(player.getItemOwned().get(0), flask);
    }

    @Test(timeout=50)
    public void EnemyTest(){
        Enemy e = new Enemy(0,0,null);
        e.setDamage(10);
        assertEquals(10, e.getDamage());
        Player p = new Player(new Point(0,0), null);
        p.collideWith(e);
        assertEquals(90, p.getHealth());
        Bullet bullet = new Bullet(new Point(0,0), new Point(1,0), null);
        bullet.setDamage(100);
        e.collideWith(bullet);
        assertTrue(e.shouldBeRemoved());
    }


//    @Test(timeout=50)
//    public void PlayerTest(){
//        Player player = new Player(new Point(0,0), null);
//        assertEquals(100, player.getHealth());
//        assertEquals(0, (int)player.getCollisionBox().getCenter().getX());
//        assertEquals(0, (int)player.getCollisionBox().getCenter().getY());
//        Merchant merchant = new Merchant(0,0,null, null);
//        assertFalse(player.hasCollideWithMerchant());
//        player.collideWith(merchant);
//        assertTrue(player.hasCollideWithMerchant());
//    }

}
