package com.mygdx.game.Entities.Item;

import com.mygdx.game.geometry.Point;

public class ExampleArmour extends Armour{
    private float armourPoint;
    private int shield;
    public ExampleArmour(Point pos) {
        super(pos, true, 100, 30, 10);
    }

}
