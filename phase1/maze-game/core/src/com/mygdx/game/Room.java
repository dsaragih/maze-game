package com.mygdx.game;
import com.badlogic.gdx.math.MathUtils;

import com.mygdx.game.Entities.*;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;
import com.mygdx.game.graphics.IPresenter;

import java.util.ArrayList;

/**
 * Represents a room
 */
public class Room implements IDrawble {
    private final IPresenter presenter;
    private final IEntityManager entityManager = new EntityManager();

    private ArrayList<Door> tempDoorStorer = new ArrayList<>();

    public Room(IPresenter presenter, Player player, int screenWidth, int screenHeight){
        this.presenter = presenter;
        entityManager.addCollidableEntity(player);

        int numEnemies = MathUtils.random(1, 3);
        for(int i = 0; i < numEnemies; ++i){
            Point enemy_pos = new Point(MathUtils.random(0, screenWidth), MathUtils.random(0, screenHeight));
            Enemy enemy = new Enemy(enemy_pos, presenter.getEnemyDrawer());
            player.addObserver(enemy);
            entityManager.addCollidableEntity(enemy);
        }
    }

    /**
     * Update the entity manager
     */
    public void update(){
        entityManager.update();
    }

    /**
     * Add a door
     * @param door a door
     */
    public void addDoor(Door door){
        entityManager.addCollidableEntity(door);
    }

    /**
     * Draw the room
     */
    public void draw(){
        presenter.getRoomDrawer().drawRoom();
        entityManager.draw();
    }

    public IEntityManager getEntityManager(){
        return entityManager;
    }
}
