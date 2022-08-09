
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
public class ItemTest {
    @Test(timeout=50)
    public void ArmourTest(){
        EntityManager manager = new EntityManager();
        ExampleArmour armour = new ExampleArmour(1,1);
        Point q1 = new Point(0,0);
        Point q2 = new Point(1,0);
        Enemy e1 = new Enemy(q1, null);
        e1.setDamage(35);
        Player p2 = new Player(q2, null);
        //p2.setArmour(armour);
        //assertEquals(p2.getShield(), 30);
        p2.collideWith(e1);
        assertEquals(p2.getHealth(), 65);
        //assertEquals(p2.getShield(), 0);
    }

    @Test(timeout=50)
    public void BulletTest() {
        Bullet bullet = new Bullet(new Point(0, 0), new Point(1, 0), null);
        bullet.update();
        assertEquals(30.0, bullet.getCollisionBox().center.x, 0.01);
        assertEquals(0.0, bullet.getCollisionBox().center.y, 0.01);
        Point q1 = new Point(0,0);
        Enemy e1 = new Enemy(q1, null);
        bullet.collideWith(e1);
        e1.collideWith(bullet);
        assertTrue(bullet.shouldBeRemoved());
        assertEquals(e1.getHealth(), 85);
    }

    @Test(timeout=50)
    public void DoorTest(){

    }
    @Test(timeout=50)
    public void GunTest(){

    }

    @Test(timeout=50)
    public void HealthFlaskTest(){

    }
    @Test(timeout=50)
    public void WeaponTest(){

    }

}
