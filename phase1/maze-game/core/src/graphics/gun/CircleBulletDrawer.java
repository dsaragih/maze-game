package graphics.gun;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import geometry.Point;

public class CircleBulletDrawer implements IBulletDrawer{
    private int radius = 2;
    private ShapeRenderer shapeRenderer;
    public CircleBulletDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawBullet(Point pos) {
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(pos.x, pos.y, radius);
    }
}
