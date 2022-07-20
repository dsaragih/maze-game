package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.Entities.Gun;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IPresenter;
import com.mygdx.game.graphics.ShapePresenter;

public class MazeGame extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	private final int SCREEN_WIDTH = 960;
	private final int SCREEN_HEIGHT = 540;

	private Player player;
	private Level level;
	private IPresenter presenter;

	private SpriteBatch batch;
	private BitmapFont font;
	private InputController controller;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);

		shapeRenderer = new ShapeRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
		presenter = new ShapePresenter(shapeRenderer, SCREEN_WIDTH, SCREEN_HEIGHT);

		Gun gun = new Gun(new Point(SCREEN_WIDTH/2f, SCREEN_HEIGHT/2f), presenter.getGunDrawer());
		player = new Player(new Point(SCREEN_WIDTH/2f, SCREEN_HEIGHT/2f), presenter.getPlayerDrawer(), gun);
		level = new Level(presenter, player, SCREEN_WIDTH, SCREEN_HEIGHT);

		controller = new InputController(camera, player);
	}

	@Override
	public void render () {
		update();
		draw();
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
		batch.dispose();
		font.dispose();
	}

	private void update(){
		if(player.getHealth() <= 0){
			return;
		}
		controller.checkForInput();
		level.update();
	}

	private void draw() {
		ScreenUtils.clear(0, 0, 0, 1);
		camera.update();
		presenter.start(camera);
		level.draw();
		player.draw();
		presenter.end();
		batch.begin();
		if(player.getHealth() <= 0){
			font.draw(batch, "YOU DIED", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
		}else{
			font.draw(batch, "Health: " + player.getHealth(), 10, 20);
		}
		batch.end();

	}
}
