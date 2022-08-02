package com.mygdx.game.graphics.entities.Merchant;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.geometry.Point;

import java.util.ArrayList;

public class CircleMerchantDrawer implements IMerchantDrawer{
    private final int radius = 15;
    private final ShapeRenderer shapeRenderer;
    public CircleMerchantDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public void drawMerchant(Point pos) {
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.circle(pos.x,pos.y, radius);
    }
    @Override
    public void drawItemList(Point pos, ArrayList<Item> itemList)
    {
        SpriteBatch batch = new SpriteBatch();
        float i = 0.0f;
        BitmapFont font = new BitmapFont();
        for (Item item: itemList){
            font.draw(batch, item.toString() + " price: " + item.checkValue() + " input: " + itemList.indexOf(item), pos.x, pos.y-i);
            i += 30;
    }}
}
