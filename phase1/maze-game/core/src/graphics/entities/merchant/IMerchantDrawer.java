package graphics.entities.merchant;

import entities.item.Item;
import geometry.Point;

import java.util.ArrayList;

public interface IMerchantDrawer {

    void drawMerchant(Point pos);

    void drawItemList(Point pos, ArrayList<Item> itemList);
}
