package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Entities.Gun;
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
        dir.x = dirCalc(Gdx.input.isKeyPressed(Input.Keys.A), Gdx.input.isKeyPressed(Input.Keys.D));
        dir.y = dirCalc(Gdx.input.isKeyPressed(Input.Keys.S), Gdx.input.isKeyPressed(Input.Keys.W));

        level.movePlayer(dir);

        Point mousePos = new Point(Gdx.input.getX(), Gdx.input.getY());
        Vector3 unprotectedMousePos = camera.unproject(new Vector3(mousePos.x, mousePos.y, 0));
        mousePos = new Point(unprotectedMousePos.x, unprotectedMousePos.y);

        level.setMousePos(mousePos);

         if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            level.mouseClick(mousePos);
         }

    }

    /**
     * Calculate the direction
     * @param a
     * @param b
     * @return
     */
    private int dirCalc(boolean a, boolean b){
        if(a == b){
            return 0;
        }

        return b ? 1 : -1;
    }
}
