package graphics.otherDrawers.healthbar;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import config.GameConstants;

public class HealthBarDrawer implements IHealthBarDrawer{

    private ShapeRenderer shapeRenderer;

    public HealthBarDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public void drawHealthBar(int playerHealth) {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(30, 15, GameConstants.PLAYER_MAX_HEALTH, 10);

        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(30, 15, playerHealth, 10);

    }
}
