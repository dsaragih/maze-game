package graphics.bullet;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.GameConstants;
import geometry.Point;

public class CircleBulletDrawer implements IBulletDrawer{
    private ShapeRenderer shapeRenderer;

    public CircleBulletDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public void drawBullet(Point pos) {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(pos.x, pos.y, GameConstants.BULLET_RADIUS);
    }
}
