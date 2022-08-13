package graphics.entityDrawers.merchant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import config.GameConstants;
import game.entities.item.Item;
import geometry.Point;

import java.util.ArrayList;

public class CircleMerchantDrawer implements IMerchantDrawer{
    private final ShapeRenderer shapeRenderer;
    private final Stage stage;
    public CircleMerchantDrawer(final ShapeRenderer shapeRenderer, final Stage stage){
        this.shapeRenderer = shapeRenderer;
        this.stage = stage;
    }

    @Override
    public void drawMerchant(final Point pos, final boolean showMenu, final ArrayList<Item> items) {
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.circle(pos.getX(),pos.getY(), GameConstants.MERCHANT_RADIUS);

        final Label.LabelStyle style = new Label.LabelStyle();
        style.font = new BitmapFont();
        style.fontColor = Color.NAVY;

        final Label merchantLabel = new Label("Merchant", style);
        merchantLabel.setPosition(pos.getX() - merchantLabel.getPrefWidth() / 2, pos.getY() + 20);
        stage.addActor(merchantLabel);

        if (showMenu) {
            float i = 0.0f;
            for (final Item item : items) {
                final Label itemLabel = new Label(item.toString() + " price: " + item.getPrice() +
                        " input: " + (items.indexOf(item) + 1), style);
                itemLabel.setSize(Gdx.graphics.getWidth(), 20);
                itemLabel.setPosition(0, pos.getY() - i);
                itemLabel.setAlignment(Align.center);
                stage.addActor(itemLabel);
                i += 30;
            }
        }
    }
}
