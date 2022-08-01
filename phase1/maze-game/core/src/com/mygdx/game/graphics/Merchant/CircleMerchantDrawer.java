package com.mygdx.game.graphics.Merchant;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.geometry.Point;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;

public class CircleMerchantDrawer implements IMerchantDrawer{
    private final int radius = 12;
    private final ShapeRenderer shapeRenderer;
    public CircleMerchantDrawer(ShapeRenderer shapeRenderer){
        this.shapeRenderer = shapeRenderer;
    }

    @Override
    public void drawMerchant(Point pos) {
        shapeRenderer.setColor(Color.BROWN);
        shapeRenderer.circle(pos.x,pos.y, radius);
    }
    public void drawItemList(Point pos, ArrayList<Item> itemList)
    {
        BitmapFont font = new BitmapFont();
        for (Item item: itemList){
    }}
}
