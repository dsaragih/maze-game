package console.launcher;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import config.GameConstants;
import entities.rooms.Level;
import entities.characters.Player;
import geometry.Point;
import graphics.IUIPresenter;
import graphics.UIPresenter;
import graphics.presenters.IDrawerFactory;
import graphics.presenters.ShapeDrawerFactory;
import manager.InputController;

/**
 * Represents a mazegame
 * @author Ethan
 * @author Daniel
 */
public class MazeGame extends ApplicationAdapter {
	private Player player;
	private Level level;
	private IDrawerFactory drawerFactory;
	private IUIPresenter UIPresenter;
	private InputController controller;

	/**
	 * Create a new game
	 */
	@Override
	public void create () {
		UIPresenter = new UIPresenter();
		drawerFactory = new ShapeDrawerFactory(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
		player = new Player(new Point(GameConstants.SCREEN_WIDTH/2f, GameConstants.SCREEN_HEIGHT/2f), drawerFactory.getPlayerDrawer(), drawerFactory.getHealthBarDrawer());
		level = new Level(drawerFactory, UIPresenter, player, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);

		controller = new InputController(level);
	}

	/**
	 * Do update and draw
	 */
	@Override
	public void render () {
		update();
		draw();
	}

	/**
	 * Dispose the shape renderer, batch and font
	 */
	@Override
	public void dispose () {
		drawerFactory.dispose();
		UIPresenter.dispose();
	}

	/**
	 * Update the player, controller and level status
	 */
	private void update(){
		if(level.isOver()){
			return;
		}
		controller.checkForInput();
		level.update();
	}

	/**
	 * Draw the game
	 */
	private void draw() {
		ScreenUtils.clear(0, 0, 0, 1);
		drawerFactory.onStartRender();
		level.draw();
		player.draw();
		drawerFactory.onEndRender();

		UIPresenter.draw();
	}
}
