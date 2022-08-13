import game.entities.characters.Enemy;
import game.entities.characters.Player;
import game.entities.item.Bullet;
import geometry.Point;
import graphics.entityDrawers.player.CirclePlayerDrawer;
import graphics.otherDrawers.healthbar.HealthBarDrawer;
import manager.EntityManager;
import static org.junit.Assert.*;
import org.junit.Test;

public class ManagerTest {
    @Test(timeout=50)
    public void EntityManagerAddEntityTest(){
        final CirclePlayerDrawer draw = new CirclePlayerDrawer(null);
        final HealthBarDrawer health = new HealthBarDrawer(null);
        final Point pos = new Point(1,1);
        final Player player = new Player(pos, draw);
        final EntityManager entityManager = new EntityManager();
        entityManager.addCollidableEntity(player);
        entityManager.update();
        assertTrue(entityManager.getEntities().contains(player));
    }

    @Test(timeout=50)
    public void EntityManagerRemoveEntityTest(){
        final Point pos = new Point(1,1);
        final Player player = new Player(pos, null);
        final EntityManager entityManager = new EntityManager();
        entityManager.addCollidableEntity(player);
        entityManager.update();
        entityManager.update();
        assertTrue(entityManager.getEntities().contains(player));
    }

    @Test(timeout=50)
    public void EntityManagerRemoveEntityTest2() {
        final EntityManager manager = new EntityManager();
        final Bullet bullet = new Bullet(new Point(0, 0), new Point(1, 0), null);
        bullet.update();
        manager.addCollidableEntity(bullet);
        final Point q1 = new Point(0, 0);
        final Enemy e1 = new Enemy(q1, null);
        bullet.collideWith(e1);
        e1.collideWith(bullet);
        assertTrue(bullet.shouldBeRemoved());
        manager.update();
        manager.update();
        assertFalse(manager.getEntities().contains(bullet));
    }
    @Test(timeout=50)
    public void EntityManagerIsFinishedTest(){
        final EntityManager manager = new EntityManager();
        final Point q1 = new Point(0,0);
        final Enemy e1 = new Enemy(q1, null);
        manager.addCollidableEntity(e1);
        manager.update();
        assertFalse(manager.isFinished());
    }

    @Test(timeout=50)
    public void EntityManagerIsFinishedTest2(){
        final EntityManager manager = new EntityManager();
        manager.update();
        assertTrue(manager.isFinished());
    }

}
