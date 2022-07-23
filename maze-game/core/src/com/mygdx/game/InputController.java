package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Entities.Gun;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.geometry.Point;

public class InputController {
    private final Player player;
    private final Camera camera;
    private final Gun gun;

    public InputController(Camera camera, Player player, Gun gun){
        this.player = player;
        this.camera = camera;
        this.gun = gun;
    }

    public void checkForInput(){
        Point dir = new Point(0,0);
        dir.x = dirCalc(Gdx.input.isKeyPressed(Input.Keys.A), Gdx.input.isKeyPressed(Input.Keys.D));
        dir.y = dirCalc(Gdx.input.isKeyPressed(Input.Keys.S), Gdx.input.isKeyPressed(Input.Keys.W));

        player.move(dir);

        Point mousePos = new Point(Gdx.input.getX(), Gdx.input.getY());
        Vector3 unprotectedMousePos = camera.unproject(new Vector3(mousePos.x, mousePos.y, 0));
        mousePos = new Point(unprotectedMousePos.x, unprotectedMousePos.y);

        player.setMousePos(mousePos);

         if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            gun.fire(mousePos);
         }

    }

    private int dirCalc(boolean a, boolean b){
        if(a == b){
            return 0;
        }

        return b ? 1 : -1;
    }
}
