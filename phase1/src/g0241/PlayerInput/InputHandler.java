package g0241.PlayerInput;

import g0241.PlayerInput.Keys.*;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class InputHandler {

    Map<Integer, Key> keyMap;
    public InputHandler(){
        KeyW w = new KeyW();
        KeyA a = new KeyA();
        KeyS s = new KeyS();
        KeyD d = new KeyD();
        KeyESC esc = new KeyESC();
        //as keys are added, instantiate one here

        //until here, where we add them to a hashmap
        keyMap = new HashMap<>();
        keyMap.put(KeyEvent.VK_W, w);
        keyMap.put(KeyEvent.VK_A, a);
        keyMap.put(KeyEvent.VK_S, s);
        keyMap.put(KeyEvent.VK_D, d);
        keyMap.put(KeyEvent.VK_ESCAPE, esc);

    }


    public void pressed(int keyCode){
        keyMap.get(keyCode).pressedAction();
    }

    public void released(int keyCode){
        keyMap.get(keyCode).releasedAction();
    }

    public void typed(int keyCode){
        keyMap.get(keyCode).typedAction();
    }
}
