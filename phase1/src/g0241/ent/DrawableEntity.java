package g0241.ent;

import g0241.Interface.Drawable;
import javax.swing.*;
import java.awt.*;

public abstract class DrawableEntity extends Entity implements Drawable {
    int width, height;
    Image[] images;
    int state;

    public DrawableEntity(float x, float y) {
        super(x, y);
    }
    public DrawableEntity(int x, int y){
        super(x,y);
    }

    protected void getImageDimensions() {

        width = images[state].getWidth(null);
        height = images[state].getHeight(null);
    }

    protected void loadImage(String[] imageNames) {

        ImageIcon ii = new ImageIcon(imageNames[state]);
        images[state] = ii.getImage();
    }

    public Image getImage() {
        return images[state];
    }

    public Rectangle getBounds() {
        return new Rectangle(Math.round(cords.getX()), Math.round(cords.getY()), width, height);
    }

    protected abstract void act();
}
