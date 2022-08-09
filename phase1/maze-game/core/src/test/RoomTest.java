
import game.entities.characters.Enemy;
import game.entities.characters.Player;
import game.entities.item.Bullet;
import game.entities.item.ExampleArmour;
import game.entities.characters.Merchant;
import game.entities.item.Item;
import game.entities.rooms.Room;
import geometry.Point;
import graphics.game.entities.drawers.player.CirclePlayerDrawer;
import graphics.healthbar.HealthBarDrawer;
import graphics.presenters.IDrawerFactory;
import graphics.presenters.ShapeDrawerFactory;
import manager.EntityManager;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
public class RoomTest {
    @Test
    public void RoomTest1(){
//        IDrawerFactory factory = new ShapeDrawerFactory(null, 1000, 1000);
        Player p = new Player(new Point(0,0), null);
        Room room = new Room(null, p, 1000, 1000);

    }

}
