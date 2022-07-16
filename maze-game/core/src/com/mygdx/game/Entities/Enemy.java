package com.mygdx.game.Entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.geometry.Circle;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graphics.entities.IEntityDrawer;
import com.mygdx.game.graphics.entities.enemy.IEnemyDrawer;

public class Enemy extends Entity {
    private float speed;
    private IEnemyDrawer enemyDrawer;

    public Enemy(int x, int y, IEnemyDrawer enemyDrawer) {
        super(x, y);
        speed = 150;
        this.enemyDrawer = enemyDrawer;
    }

    public Enemy(Point pos, IEnemyDrawer enemyDrawer) {
        super(pos);
        speed = 150;

        this.enemyDrawer = enemyDrawer;
    }

    public Circle getCollisionBox(){
        return new Circle(pos, 10);
    }

    @Override
    public void draw() {
        enemyDrawer.drawEnemy(pos);
    }

    public void update(Player player) {
        Point dir = pos.separation(player.pos).normalized();
        dir.multiply(-speed * Gdx.graphics.getDeltaTime());
        pos.add(dir);
    }
}
