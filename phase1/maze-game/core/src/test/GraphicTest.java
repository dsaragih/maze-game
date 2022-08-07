import entities.characters.Player;
import entities.item.ExampleArmour;
import geometry.Point;
import graphics.entities.player.CirclePlayerDrawer;
import manager.EntityManager;
import manager.InventoryManager;
import org.junit.Test;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class GraphicTest {
    @Test(timeout=50)
    public void EntityManagerAddEntityTest(){
        ExampleArmour armour = new ExampleArmour(1,1);
        Point pos = new Point(1,1);
        CirclePlayerDrawer draw = new CirclePlayerDrawer(new ShapeRenderer());
        Player player = new Player(pos, draw);
        EntityManager entityManager = new EntityManager();
        entityManager.addCollidableEntity(armour);
        entityManager.addCollidableEntity(player);
        entityManager.update();

    }

}
