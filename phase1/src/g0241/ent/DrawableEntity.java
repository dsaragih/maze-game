package g0241.ent;

import g0241.Interface.Drawable;
import javax.swing.*;
import java.awt.*;

public abstract class DrawableEntity extends Entity implements Drawable {
    float width, height;
    Image image;
    int state;

    public DrawableEntity(float x, float y) {
        super(x, y);
    }

    protected void getImageDimensions() {

        width = image[state].getWidth(null);
        height = image[state].getHeight(null);
    }

    protected void loadImage(String[] imageNames) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(Math.round(x), Math.round(y), width, height);
    }

    abstract void act();
}
