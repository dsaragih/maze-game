package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
	
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
		presenter = new ShapePresenter(shapeRenderer, SCREEN_WIDTH, SCREEN_HEIGHT);

		player = new Player(new Point(SCREEN_WIDTH/2, SCREEN_HEIGHT/2), presenter.getPlayerDrawer());
		level = new Level(presenter, player, SCREEN_WIDTH, SCREEN_HEIGHT);

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
		level.update();
	}

	private void draw() {
		ScreenUtils.clear(0, 0, 0, 1);
		camera.update();
		presenter.start(camera);
		level.draw();
		player.draw();
		presenter.end();

	}
}
