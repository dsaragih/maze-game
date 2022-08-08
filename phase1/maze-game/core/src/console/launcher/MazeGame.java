package console.launcher;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import config.GameConstants;
import game.entities.rooms.Level;
import game.entities.characters.Player;
import graphics.presenters.IPresenter;
import graphics.presenters.Presenter;
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
	private IPresenter Presenter;
	private InputController controller;

	/**
	 * Create a new game
	 */
	@Override
	public void create () {
		Presenter = new Presenter();
		drawerFactory = new ShapeDrawerFactory(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);

		level = new Level(drawerFactory, Presenter, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
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
		Presenter.dispose();
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
		Presenter.draw();
	}
}
