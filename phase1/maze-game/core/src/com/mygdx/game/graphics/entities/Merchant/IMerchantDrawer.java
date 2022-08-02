package com.mygdx.game.graphics.entities.Merchant;

import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.geometry.Point;

import java.util.ArrayList;

public interface IMerchantDrawer {

    void drawMerchant(Point pos);

    void drawItemList(Point pos, ArrayList<Item> itemList);
}
