package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.Input.Keys;

public class MazeGame extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	private final int SCREEN_WIDTH = 960;
	private final int SCREEN_HEIGHT = 540;

	private Player player;

	
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

		player = new Player(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, shapeRenderer);
	}

	@Override
	public void render () {
		update();
		draw();
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}

	private void update(){
		player.update();
	}

	private void draw() {
		ScreenUtils.clear(0, 0, 1, 1);
		camera.update();
		shapeRenderer.setProjectionMatrix(camera.combined);
		player.draw();

	}


}
