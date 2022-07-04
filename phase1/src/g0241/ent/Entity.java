package g0241.ent;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
abstract public class Entity {
    float x, y, speed
    int width, height;
    Image image;
    boolean visible;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
        this.visible = true;
    }

    void moveTo(Entity target){
        float dx = target.x - x;
        float dy = target.y - y;
        float distance = (float) Math.sqrt(dx*dx + dy*dy);
        if (distance < .0001) return; //already at destination
        float fractionTravelled = Math.max(1, speed / distance);
        dx = dx * fractionTravelled;
        dy = dy * fractionTravelled;
        x = x + dx;
        y = y + dy;
    }
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {

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
