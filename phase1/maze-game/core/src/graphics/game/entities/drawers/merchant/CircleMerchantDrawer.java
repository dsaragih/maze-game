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
    private BitmapFont font;
    public CircleMerchantDrawer(ShapeRenderer shapeRenderer, BitmapFont font){
        this.shapeRenderer = shapeRenderer;
        this.font = font;
    }

    @Override
    public void drawMerchant(Point pos, boolean showMenu, Item[] items) {
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.circle(pos.x,pos.y, GameConstants.MERCHANT_RADIUS);

//        font.draw(, "Merchant", pos.x, pos.y + 20);
//        float i = 0.0f;
//        for (Item item: items){
//            Label itemLabel = new Label(item.toString() + " price: " + item.getValue() +
//                    " input: " + (items.indexOf(item)+1), labelStyle);
//            itemLabel.setSize(Gdx.graphics.getWidth(), 20);
//            itemLabel.setPosition(0 , pos.y - i);
//            itemLabel.setAlignment(Align.center);
//            i += 30;
//        }
    }
}
