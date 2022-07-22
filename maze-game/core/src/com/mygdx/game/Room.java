package com.mygdx.game;
import com.badlogic.gdx.math.MathUtils;

import com.mygdx.game.Entities.*;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.IDrawble;
import com.mygdx.game.graphics.IPresenter;

public class Room implements IDrawble {
    private final IPresenter presenter;
    public final RoomEntityManager entityManager;

    public Room(IPresenter presenter, RoomEntityManager entityManager ){
        this.presenter = presenter;
        this.entityManager = entityManager;
    }

    public void create(Player player, int screenWidth, int screenHeight) {
        entityManager.addCollidableEntity(player);
        player.gun.setEntityManager(entityManager);
        int numEnemies = MathUtils.random(1, 6);
        for(int i = 0; i < numEnemies; ++i){
            Point enemy_pos = new Point(MathUtils.random(0, screenWidth), MathUtils.random(0, screenHeight));
            System.out.println(enemy_pos.x + " " + enemy_pos.y);
            Enemy enemy = new Enemy(enemy_pos, presenter.getEnemyDrawer());
            player.addObserver(enemy);
            entityManager.addCollidableEntity(enemy);
        }
    }

    public void update(){
        entityManager.update();
    }

    public void draw(){
        presenter.getRoomDrawer().drawRoom();
        entityManager.draw();
    }
}
