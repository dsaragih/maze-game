package graphics.door;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import geometry.Point;

import java.util.Random;

public class CircleDoorDrawer implements IDoorDrawer {
    private final ShapeRenderer shapeRenderer;
    private final float radius = 10;
    private Color color = null;

    public CircleDoorDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;

        Random rand = new Random();
        color = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat(), 1);
    }

    @Override
    public void drawDoor(Point pos) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }
}
