package graphics.game.entities.drawers.merchant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import config.GameConstants;
import game.entities.item.Item;
import geometry.Point;

import java.util.ArrayList;

public class CircleMerchantDrawer implements IMerchantDrawer{
    private ShapeRenderer shapeRenderer;
    private Label.LabelStyle labelStyle;
    public CircleMerchantDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
        labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        labelStyle.fontColor = Color.NAVY;
    }

    @Override
    public void drawMerchant(Point pos) {
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.circle(pos.x,pos.y, GameConstants.MERCHANT_RADIUS);

        Label merchantLabel = new Label("Merchant", labelStyle);
        merchantLabel.setPosition(pos.x - merchantLabel.getPrefWidth() / 2f, pos.y + 20);
    }
    @Override
    public void drawItemList(Point pos, ArrayList<Item> itemList)
    {
        float i = 0.0f;
        for (Item item: itemList){
            Label itemLabel = new Label(item.toString() + " price: " + item.getValue() +
                    " input: " + (itemList.indexOf(item)+1), labelStyle);
            itemLabel.setSize(Gdx.graphics.getWidth(), 20);
            itemLabel.setPosition(0 , pos.y - i);
            itemLabel.setAlignment(Align.center);
            i += 30;
        }
    }
}
