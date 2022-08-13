package graphics.otherDrawers.room;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SimpleShapeRoomDrawer implements IRoomDrawer{

    private final ShapeRenderer shapeRenderer;
    private final int screenWidth;
    private final int screenHeight;
    public SimpleShapeRoomDrawer(final ShapeRenderer shapeRenderer, final int screenWidth, final int screenHeight){
        this.shapeRenderer = shapeRenderer;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    @Override
    public void drawRoom() {
        shapeRenderer.setColor(Color.GRAY);
        shapeRenderer.rect(0, 0, screenWidth, screenHeight);
    }

}
