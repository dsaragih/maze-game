package graphics.entityDrawers.gun;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.GameConstants;
import geometry.Point;

public class CircleGunDrawer implements IGunDrawer{

    private final ShapeRenderer shapeRenderer;
    public CircleGunDrawer(final ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawGun(final Point pos) {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(pos.getX(), pos.getY(), GameConstants.GUN_RADIUS);
    }
}
