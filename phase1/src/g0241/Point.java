package g0241;

public class Point {
    private float x,y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Point p){
        x += p.x;
        y += p.y;
    }

    public void multiply(float scalar){
        x *= scalar;
        y *= scalar;
    }

    public void setPos(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

}
