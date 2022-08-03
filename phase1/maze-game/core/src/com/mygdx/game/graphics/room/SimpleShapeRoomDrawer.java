package com.mygdx.game.graphics.room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Entities.Door;
import com.mygdx.game.Entities.Entity;

import java.util.List;

public class SimpleShapeRoomDrawer implements IRoomDrawer{

    private final ShapeRenderer shapeRenderer;
    private final int screenWidth;
    private final int screenHeight;
    private Stage stage;
    public SimpleShapeRoomDrawer(ShapeRenderer shapeRenderer, Stage stage, int screenWidth, int screenHeight){
        this.shapeRenderer = shapeRenderer;
        this.stage = stage;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    @Override
    public void drawRoom() {
//        shapeRenderer.setColor(Color.GRAY);
//        shapeRenderer.rect(0, 0, screenWidth, screenHeight);
        Texture texture = new Texture(Gdx.files.internal("chiseled_nether_bricks.png"));
        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegion(0,0,screenWidth,screenHeight);

        Image image = new Image(textureRegion);
        image.setPosition(0, 0);
        stage.addActor(image);

    }

}
