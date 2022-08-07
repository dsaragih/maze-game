package graphics.room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SandRoomDrawer implements IRoomDrawer {
    private int screenWidth;
    private int screenHeight;
    private SpriteBatch spriteBatch;
    Texture texture;
    TextureRegion textureRegion;
    public SandRoomDrawer(SpriteBatch spriteBatch, int screenWidth, int screenHeight){
        this.spriteBatch = spriteBatch;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        texture = new Texture(Gdx.files.internal("chiseled_sandstone.png"));
        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        textureRegion = new TextureRegion(texture);
        textureRegion.setRegion(0, 0, screenWidth, screenHeight);
    }
    @Override
    public void drawRoom() {
        spriteBatch.draw(textureRegion, 0, 0);
    }
}
