package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Entities.Merchant;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.geometry.Point;

/**
 * Represents an input controller
 * @author Ethan
 * @author Ian
 * @author Daniel
 */
public class InputController {
    private final Level level;
    private final Camera camera;

    /**
     * Create an input controller
     * @param camera the camera
     * @param level the level
     */
    public InputController(Camera camera, Level level){
        this.level = level;
        this.camera = camera;
    }

    /**
     * Check for input
     */
    public void checkForInput(){
        Point dir = new Point(0,0);
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.D)
        || Gdx.input.isKeyPressed(Input.Keys.S) ||  Gdx.input.isKeyPressed(Input.Keys.W)){
        dir.x = dirCalc(Gdx.input.isKeyPressed(Input.Keys.A), Gdx.input.isKeyPressed(Input.Keys.D));
        dir.y = dirCalc(Gdx.input.isKeyPressed(Input.Keys.S), Gdx.input.isKeyPressed(Input.Keys.W));}
        //An alternative set of inputs
        else{
            dir.x = dirCalc(Gdx.input.isKeyPressed(Input.Keys.LEFT), Gdx.input.isKeyPressed(Input.Keys.RIGHT));
            dir.y = dirCalc(Gdx.input.isKeyPressed(Input.Keys.DOWN), Gdx.input.isKeyPressed(Input.Keys.UP));
        }
        level.movePlayer(dir);

        Point mousePos = new Point(Gdx.input.getX(), Gdx.input.getY());
        Vector3 unprotectedMousePos = camera.unproject(new Vector3(mousePos.x, mousePos.y, 0));
        mousePos = new Point(unprotectedMousePos.x, unprotectedMousePos.y);

        level.setMousePos(mousePos);

         if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            level.mouseClick(mousePos);
         }
         Player player = level.getPlayer();
         if (player.hasCollidewithMerchant()){
             Merchant merchant = player.getCurrMerchant();
             if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
                 player.buy(merchant.getItemOwned().get(0));
             }
         }
         if (Gdx.input.isKeyPressed(Input.Keys.J)){
             player.useArmour();
         }

    }

    /**
     * Calculate the direction the user wants to move on an axis.
     * @param left indicates whether the key to go left is pressed.
     * @param right indicates whether the key to go right is pressed.
     * @return 1 for right, -1 for left and 0 for no movment wanted.
     */
    private int dirCalc(boolean left, boolean right){
        if(left == right){
            return 0;
        }

        return right ? 1 : -1;
    }
}
