package graphics.entities.enemy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.GameConstants;
import geometry.Point;

public class CircleEnemyDrawer implements IEnemyDrawer{
    private ShapeRenderer shapeRenderer;
    public CircleEnemyDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawEnemy(Point pos) {
        shapeRenderer.setColor(Color.NAVY);
        shapeRenderer.circle(pos.x, pos.y, GameConstants.ENEMY_RADIUS);
    }
}
