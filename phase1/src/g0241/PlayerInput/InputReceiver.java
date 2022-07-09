package g0241.PlayerInput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputReceiver implements KeyListener {

    private final InputHandler inputhandler = new InputHandler();


    @Override
    public void keyPressed(KeyEvent e) {
        //use for starting movement, charging weapon/auto-fire?


        inputhandler.pressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //stopping anything in pressed
        inputhandler.released(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //menu openers - inventory, esc menu, etc.
        inputhandler.typed(e.getKeyCode());
    }

}
