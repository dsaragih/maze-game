package graphics.entityDrawers.door;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.GameConstants;
import geometry.Point;

import java.util.Random;

public class CircleDoorDrawer implements IDoorDrawer {
    private final ShapeRenderer shapeRenderer;
    private final Color color;

    public CircleDoorDrawer(final ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;

        final Random rand = new Random();
        color = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat(), 1);
    }

    @Override
    public void drawDoor(final Point pos) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(pos.getX(), pos.getY(), GameConstants.DOOR_RADIUS);
    }
}
