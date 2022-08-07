package entities.characters;
import com.badlogic.gdx.Gdx;
import config.GameConstants;
import entities.item.Bullet;
import entities.abstractions.CollidableEntity;
import entities.abstractions.ICollidable;
import entities.abstractions.IPlayerObserver;
import entities.item.Door;
import entities.item.Item;
import entities.item.Merchant;
import geometry.Circle;
import geometry.Point;
import graphics.entities.enemy.IEnemyDrawer;
import com.badlogic.gdx.math.MathUtils;

/** Represents an enemy
 * @author Ethan
 * @author Ian Curtis Ewing\
 * @author Daniel
 */
public class Enemy extends CollidableEntity implements IPlayerObserver {

    private Point velocity = new Point(0,0);
    private IEnemyDrawer enemyDrawer;
    private int health = 100;
    private Point target = null;

    private int value = MathUtils.random(1,3);

    /**
     * Create an enemy
     * @param x the x-coordinate of enemy
     * @param y the y-coordinate of enemy
     * @param enemyDrawer the drawer of enemy
     */
    public Enemy(int x, int y, IEnemyDrawer enemyDrawer) {
        super(x, y, true);
        this.enemyDrawer = enemyDrawer;
    }

    /**
     * Create an enemy
     * @param pos the position of the enemy
     * @param enemyDrawer the drawer of enemy
     */
    public Enemy(Point pos, IEnemyDrawer enemyDrawer) {
        super(pos,true);
        this.enemyDrawer = enemyDrawer;
    }

    /**
     * Return the collision box of the enemy
     * @return the circle representation of the collision box.
     */
    public Circle getCollisionBox(){
        return new Circle(pos, GameConstants.ENEMY_RADIUS);
    }

    /**
     * Inform the other objects being collided with.
     */
    @Override
    public void informCollision(ICollidable other) {
        other.collideWith(this);
    }

    @Override
    public void collideWith(Merchant merchant) {

    }

    /**
     * Collide with the player.
     * @param player
     */
    public void collideWith(Player player) {
        Point dir = player.pos.distanceVector(pos).normalized();
        dir.multiply(-1f);
        velocity.add(dir);
    }

    /**
     * Collide with the enemy
     * @param enemy the enemy being collided with the enemy
     */
    @Override
    public void collideWith(Enemy enemy) {
        Point dir = enemy.pos.distanceVector(pos).normalized();
        dir.multiply(-1f);
        velocity.add(dir);
    }

    /**
     * Collide with the door
     * @param door the door being collided with the door
     */
    public void collideWith(Door door) {

    }

    /**
     * Collide with the bullet
     * @param bullet the bullet being collided with the door
     */
    @Override
    public void collideWith(Bullet bullet) {
        this.health -= bullet.getDamage();
    }

    @Override
    public void collideWith(Item item) {

    }

    /**
     * Draw the enemy
     */
    @Override
    public void draw() {
        enemyDrawer.drawEnemy(pos);
    }

    /**
     * Determine whether the enemy should be removed.
     * @return whether the health is non-positive.
     */
    @Override
    public boolean shouldBeRemoved() {
        return health <= 0;
    }

    /**
     * Update the movement of the enemy.
     */
    public void update() {
        if(target == null){
            return;
        }

        Point dirVector = target.distanceVector(pos).normalized();
        dirVector.multiply(GameConstants.ENEMY_ACCELERATION * Gdx.graphics.getDeltaTime());
        if(pos.x > GameConstants.SCREEN_WIDTH && velocity.x > 0){
            velocity.x = 0;
        }
        if(pos.y > GameConstants.SCREEN_HEIGHT && velocity.y > 0){
            velocity.y = 0;
        }
        if(pos.x < 0 && velocity.x < 0){
            velocity.x = 0;
        }
        if(pos.y < 0 && velocity.y <0){
            velocity.y = 0;
        }
        velocity.add(dirVector);
        velocity.multiply(1 - GameConstants.ENEMY_FRICTION);
        if(velocity.isZero()){
            return;
        }
        Point newDir = velocity.normalized();
        if(newDir.length() > GameConstants.ENEMY_MAX_SPEED){
            newDir.multiply(GameConstants.ENEMY_MAX_SPEED);
            velocity = newDir;
        }

        pos.add(velocity);

    }

    /**
     * Get the damage that the enemy can deal
     * @return the damage
     */
    public int getDamage(){
        return GameConstants.ENEMY_DAMAGE;
    }

    /**
     * Set the target point of the enemy
     * @param newTarget The target of enemy.
     */
    public void setTarget(Point newTarget){
        target = newTarget;
    }

    public int getValue(){return value;}
}
