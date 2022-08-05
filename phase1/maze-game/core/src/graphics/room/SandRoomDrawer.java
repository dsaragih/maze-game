package graphics.room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SandRoomDrawer implements IRoomDrawer {
    private final int screenWidth;
    private final int screenHeight;
    private Stage stage;
    public SandRoomDrawer(Stage stage, int screenWidth, int screenHeight){
        this.stage = stage;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    @Override
    public void drawRoom() {
        stage.getBatch().begin();
        Texture texture = new Texture(Gdx.files.internal("chiseled_sandstone.png"));
        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegion(0, 0, screenWidth, screenHeight);

        stage.getBatch().draw(textureRegion, 0, 0);
        stage.getBatch().end();
    }
}
