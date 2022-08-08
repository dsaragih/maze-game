
import entities.characters.Enemy;
import entities.characters.Player;
import entities.item.*;
import geometry.Point;
import graphics.bullet.CircleBulletDrawer;
import graphics.entities.player.CirclePlayerDrawer;
import graphics.gun.CircleGunDrawer;
import graphics.gun.IGunDrawer;
import graphics.healthbar.HealthBarDrawer;
import manager.EntityManager;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class ManagerTest {
    @Test(timeout=50)
    public void EntityManagerAddEntityTest(){
        ExampleArmour armour = new ExampleArmour(1,1);
        CirclePlayerDrawer draw = new CirclePlayerDrawer(null);
        HealthBarDrawer health = new HealthBarDrawer(null);
        Point pos = new Point(1,1);
        Player player = new Player(pos, draw);
        EntityManager entityManager = new EntityManager();
        entityManager.addCollidableEntity(armour);
        entityManager.addCollidableEntity(player);
        entityManager.update();
        assertTrue(entityManager.getEntities().contains(player));
        assertTrue(entityManager.getEntities().contains(armour));
    }

    @Test(timeout=50)
    public void EntityManagerRemoveEntityTest(){
        ExampleArmour armour = new ExampleArmour(1,1);
        Point pos = new Point(1,1);
        CirclePlayerDrawer draw = new CirclePlayerDrawer(null);
        Player player = new Player(pos, draw);
        EntityManager entityManager = new EntityManager();
        entityManager.addCollidableEntity(armour);
        entityManager.addCollidableEntity(player);
        entityManager.update();
        entityManager.removeEntity(armour);
        entityManager.update();
        assertTrue(entityManager.getEntities().contains(player));
        assertFalse(entityManager.getEntities().contains(armour));
    }

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
        assertEquals(p2.getHealth(), 95);
        //assertEquals(p2.getShield(), 0);
    }

    @Test(timeout=50)
    public void BulletTest() {
        Bullet bullet = new Bullet(new Point(0, 0), new Point(1, 0), null);
        bullet.update();
        assertEquals(30.0, (double) bullet.getCollisionBox().center.x, 0.01);
        assertEquals(0.0, (double) bullet.getCollisionBox().center.y, 0.01);
        Point q1 = new Point(0,0);
        Enemy e1 = new Enemy(q1, null);
        bullet.collideWith(e1);
        e1.collideWith(bullet);
        assertTrue(bullet.shouldBeRemoved());
        assertEquals(e1.getHealth(), 85);
    }

    @Test(timeout=50)
    public void MerchantTest(){
        ExampleArmour armour = new ExampleArmour(0,0);
        Merchant merchant = new Merchant(0,0, null);
        //merchant.addItem(armour);
        Player player = new Player(new Point(0,0), null);
        player.collideWith(merchant);
        //player.buy(armour);
        //assertTrue(player.getItem().contains(armour));
    }

}
