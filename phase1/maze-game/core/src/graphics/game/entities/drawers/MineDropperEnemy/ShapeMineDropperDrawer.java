package graphics.game.entities.drawers.MineDropperEnemy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.GameConstants;
import geometry.Point;

public class ShapeMineDropperDrawer implements IMineDropperDrawer{

    private ShapeRenderer shapeRenderer;
    public ShapeMineDropperDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }
    @Override
    public void drawMineDropper(Point pos) {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(pos.x, pos.y, 30);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(pos.x, pos.y, 20);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(pos.x, pos.y, 10);
    }
}
