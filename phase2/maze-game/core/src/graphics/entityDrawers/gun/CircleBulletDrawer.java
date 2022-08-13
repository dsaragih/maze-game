package graphics.entityDrawers.gun;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.GameConstants;
import geometry.Point;

public class CircleBulletDrawer implements IBulletDrawer{
    private final ShapeRenderer shapeRenderer;
    public CircleBulletDrawer(final ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawBullet(final Point pos) {
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(pos.getX(), pos.getY(), GameConstants.BULLET_RADIUS);
    }
}
