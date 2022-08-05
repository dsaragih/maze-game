package graphics.entities.merchant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import entities.item.Item;
import geometry.Point;

import java.util.ArrayList;

public class CircleMerchantDrawer implements IMerchantDrawer{
    private final int radius = 15;
    private final ShapeRenderer shapeRenderer;
    private final Stage stage;
    private Label.LabelStyle labelStyle;
    public CircleMerchantDrawer(ShapeRenderer shapeRenderer, Stage stage){
        this.stage = stage;
        this.shapeRenderer = shapeRenderer;
        labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        labelStyle.fontColor = Color.NAVY;
    }

    @Override
    public void drawMerchant(Point pos) {
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.circle(pos.x,pos.y, radius);


        Label merchantLabel = new Label("Merchant", labelStyle);
        merchantLabel.setPosition(pos.x - merchantLabel.getPrefWidth() / 2f, pos.y + 20);
        stage.addActor(merchantLabel);
    }
    @Override
    public void drawItemList(Point pos, ArrayList<Item> itemList)
    {
        float i = 0.0f;
        for (Item item: itemList){
            Label itemLabel = new Label(item.toString() + " price: " + item.checkValue() +
                    " input: " + (itemList.indexOf(item)+1), labelStyle);
            itemLabel.setSize(Gdx.graphics.getWidth(), 20);
            itemLabel.setPosition(0 , pos.y - i);
            itemLabel.setAlignment(Align.center);
            stage.addActor(itemLabel);
            i += 30;
        }
    }
}
