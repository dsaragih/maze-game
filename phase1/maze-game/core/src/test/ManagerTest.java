
import entities.characters.Player;
import entities.item.ExampleArmour;
import geometry.Point;
import graphics.entities.player.CirclePlayerDrawer;
import graphics.healthbar.HealthBarDrawer;
import manager.EntityManager;


import static org.junit.Assert.*;
import org.junit.Test;

public class ManagerTest {
    @Test(timeout=50)
    public void EntityManagerAddEntityTest(){
        ExampleArmour armour = new ExampleArmour(1,1);
        CirclePlayerDrawer draw = new CirclePlayerDrawer(null);
        HealthBarDrawer health = new HealthBarDrawer(null);
        Point pos = new Point(1,1);
        Player player = new Player(pos, draw, health);
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
        Player player = new Player(pos, draw, new HealthBarDrawer(null));
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
    public void



}
