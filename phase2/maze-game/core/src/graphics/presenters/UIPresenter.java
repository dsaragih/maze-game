package graphics.presenters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import config.GameConstants;
import graphics.otherDrawers.healthbar.HealthBarDrawer;
import graphics.otherDrawers.healthbar.IHealthBarDrawer;

import java.util.Collection;

public class UIPresenter implements IUIPresenter {

    //Game state which effects the UI
    private boolean isPlayerDead = false;
    private int playerShield;
    private int playerHealth;
    private int playerGold;
    private boolean playerWins = false;
    private Collection<IDrawable> drawables;


	//Variables used to draw
    private final SpriteBatch spriteBatch;
	private final Stage stage;
	private final ShapeRenderer shapeRenderer;
	private final BitmapFont font;
	private final OrthographicCamera camera;

	private final IHealthBarDrawer healthBarDrawer;
    public UIPresenter(final Stage stage){
        spriteBatch = new SpriteBatch();
		this.stage = stage;
		font = new BitmapFont();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT	);

		shapeRenderer = new ShapeRenderer();

		healthBarDrawer = new HealthBarDrawer(shapeRenderer);
    }

    @Override
    public void draw() {

		spriteBatch.setProjectionMatrix(camera.combined);
		shapeRenderer.setProjectionMatrix(camera.combined);

		spriteBatch.begin();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		drawNoOverhead();
		stage.act();
		stage.draw();

		shapeRenderer.end();
		spriteBatch.end();
		stage.clear();
    }

	private void drawNoOverhead(){
        for(final IDrawable drawable: drawables){
            drawable.draw();
        }

		final Label.LabelStyle style = new Label.LabelStyle();
		style.font = font;
		style.fontColor = Color.RED;

		if(playerWins){
			final Label label1 = new Label("YOU WIN", style);
			label1.setPosition(0, GameConstants.SCREEN_HEIGHT / 2f);
			label1.setSize(Gdx.graphics.getWidth(), 20);
			label1.setAlignment(Align.center);
			stage.addActor(label1);
			return;
		}

		if(isPlayerDead){
			final Label label1 = new Label("YOU DIED", style);
			label1.setPosition(0, GameConstants.SCREEN_HEIGHT / 2f);
			label1.setSize(Gdx.graphics.getWidth(), 20);
			label1.setAlignment(Align.center);
			stage.addActor(label1);
			return;
		}

		final Label shieldLabel = new Label("Shield: " + playerShield + "/" + GameConstants.PLAYER_MAX_SHIELD, style);
		shieldLabel.setPosition(30, 50);
		stage.addActor(shieldLabel);

		final Label goldLabel = new Label("Gold: " + playerGold, style);
		goldLabel.setPosition(875, 20);
		stage.addActor(goldLabel);

		healthBarDrawer.drawHealthBar(playerHealth);
	}

	@Override
	public void updatePlayerShield(final int playerShield) {
		this.playerShield = playerShield;
	}

	@Override
	public void updateIsPlayerDead(final boolean isPlayerDead) {
		this.isPlayerDead = isPlayerDead;
	}

	@Override
	public void updatePlayerGold(final int playerGold) {
		this.playerGold = playerGold;
	}

	public void updatePlayerHealth(final int playerHealth) {
		this.playerHealth = playerHealth;
	}

    @Override
    public void playerWins() {
        playerWins = true;
    }

    @Override
    public void setDrawables(final Collection<IDrawable> drawables) {
        this.drawables = drawables;
    }

    public void dispose(){
		font.dispose();
		spriteBatch.dispose();
		stage.dispose();
	}
}
