package graphics.healthbar;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import game.entities.characters.Player;

public class HealthBarDrawer implements IHealthBarDrawer{

    private ShapeRenderer shapeRenderer;

    public HealthBarDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public void drawHealthBar(Player player) {
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(65, 23, player.getHealth(), 10);
    }

    //@Override
    //public void drawHealthBar(Enemy enemy) {
    //    shapeRenderer.setColor(Color.RED);
    //    shapeRenderer.rect(enemy.)
    //}


}
