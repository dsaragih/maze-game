package graphics.entityDrawers.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import geometry.Point;

public class MousePlayerDrawer implements IPlayerDrawer{
    private final SpriteBatch spriteBatch;
    private final ShapeRenderer shapeRenderer;
    private final Texture mouseTexture;

    public MousePlayerDrawer(final SpriteBatch spriteBatch, final ShapeRenderer shapeRenderer){
        this.spriteBatch = spriteBatch;
        this.shapeRenderer = shapeRenderer;
        mouseTexture = new Texture(Gdx.files.internal("cat.png"));
    }
    @Override
    public void drawPlayer(final Point pos, final Point gunDirection) {
        spriteBatch.draw(mouseTexture, pos.getX(), pos.getY());
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(pos.getX() + gunDirection.getX() * 10, pos.getY() + gunDirection.getY() * 10, 3);
    }
}
