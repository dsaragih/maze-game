package com.mygdx.game.Entities;

import com.mygdx.game.Entities.Item.Armour;
import com.mygdx.game.Entities.Item.Item;
import com.mygdx.game.IEntityManager;

import java.util.ArrayList;

public class InventoryManager {
    private Player player;
    private ArrayList<Item> items;

    public InventoryManager(Player player, ArrayList<Item> items)
    {this.player = player;
    this.items = items;}
    public void addItem(Item item){items.add(item);}

    public void removeItem(Item item){items.remove(item);}
    public void use(Armour armour){player.setArmour(armour);}

    public boolean hasArmour(){
        for (Item item: items){
            if (item instanceof Armour){return true;}
        }
        return false;
    }

}
