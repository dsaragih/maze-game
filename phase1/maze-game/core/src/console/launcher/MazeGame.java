package console.launcher;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import config.GameConstants;
import entities.rooms.Level;
import entities.characters.Player;
import geometry.Point;
import graphics.presenters.IPresenter;
import graphics.presenters.ShapePresenter;
import manager.InputController;

/**
 * Represents a mazegame
 * @author Ethan
 * @author Daniel
 */
public class MazeGame extends ApplicationAdapter {
	private Player player;
	private Level level;
	private IPresenter presenter;
	private BitmapFont font;
	private InputController controller;

	/**
	 * Create a new game
	 */
	@Override
	public void create () {
		font = new BitmapFont();
		presenter = new ShapePresenter(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
		player = new Player(new Point(GameConstants.SCREEN_WIDTH/2f, GameConstants.SCREEN_HEIGHT/2f), presenter.getPlayerDrawer(), presenter.getHealthBarDrawer());
		level = new Level(presenter, player, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);

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
		presenter.dispose();
		font.dispose();
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
		presenter.onStartRender();
		level.draw();
		player.draw();
		presenter.onEndRender();


//		batch.begin();
//		Label.LabelStyle label1Style = new Label.LabelStyle();
//		label1Style.font = font;
//		label1Style.fontColor = Color.RED;
//
//		if(level.isOver()){
//			Label label1 = new Label("YOU DIED", label1Style);
//			label1.setSize(Gdx.graphics.getWidth(), 20);
//			label1.setPosition(0, GameConstants.SCREEN_HEIGHT / 2f);
//			label1.setAlignment(Align.center);
//			stage.addActor(label1);
//		}else{
//			Label label2 = new Label("Health: ", label1Style);
//			label2.setPosition(10, 20);
//			stage.addActor(label2);
//
//			Label label3 = new Label("Shield: " + player.getShield(), label1Style);
//			label3.setPosition(10, 50);
//			stage.addActor(label3);
//
//			Label label4 = new Label("Gold: " + player.getGold(), label1Style);
//			label4.setPosition(900, 20);
//			stage.addActor(label4);
//		}
//		batch.end();
	}
}
