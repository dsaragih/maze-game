package graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import config.GameConstants;

public class UIPresenter implements IUIPresenter {

	//Game state which effects the UI
    private boolean isLevelOver = false;
	private int playerShield;
	private int playerGold;


	//Variables used to draw
    private final SpriteBatch spriteBatch;
	private final BitmapFont font;
	private final OrthographicCamera camera;

    public UIPresenter(){
        spriteBatch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT	);
    }

    @Override
    public void draw() {
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		drawNoOverhead();
		spriteBatch.end();
    }

	private void drawNoOverhead(){
		if(isLevelOver){
			font.setColor(1, 0, 0, 1);
			font.draw(spriteBatch, "YOU DIED", GameConstants.SCREEN_WIDTH / 2f, GameConstants.SCREEN_HEIGHT / 2f);
			return;
		}

		font.draw(spriteBatch, "Health: ",  10, 20);
		font.draw(spriteBatch, "Shield: " + playerShield,  10, 50);
		font.draw(spriteBatch, "Gold: " + playerGold,  900, 20);
	}

	@Override
	public void updatePlayerShield(int playerShield) {
		this.playerShield = playerShield;
	}

	@Override
	public void updateIsGameOver(boolean isLevelOver) {
		this.isLevelOver = isLevelOver;
	}

	@Override
	public void updatePlayerGold(int playerGold) {
		this.playerGold = playerGold;
	}

	public void dispose(){
		font.dispose();
		spriteBatch.dispose();
	}
}
