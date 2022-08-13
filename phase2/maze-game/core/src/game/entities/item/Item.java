package game.entities.item;

import game.entities.characters.Player;


public abstract class Item {
    //Item is an object that can be picked up by the player, and has a value. This is not a class we wrote in phase 1
    //An item has a value, a name, and can be picked up or dropped.

    private final String name;
    private final int price;
    public Item(final String name, final int price) {
        this.name = name;
        this.price = price;
    }
    public abstract void operateOnPlayer(Player player);

    @Override
    public String toString(){
        return name;
    }

    public int getPrice(){
        return price;
    }

}
