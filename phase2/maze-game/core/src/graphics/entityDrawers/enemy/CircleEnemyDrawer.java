package graphics.entityDrawers.enemy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.GameConstants;
import geometry.Point;

public class CircleEnemyDrawer implements IEnemyDrawer{
    private final ShapeRenderer shapeRenderer;
    public CircleEnemyDrawer(final ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawEnemy(final Point pos) {
        shapeRenderer.setColor(Color.NAVY);
        shapeRenderer.circle(pos.getX(), pos.getY(), GameConstants.ENEMY_RADIUS);
    }
}
