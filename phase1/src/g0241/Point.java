package g0241;

public class Point {
    float x,y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setPos(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void setX(float x){
        setPos(x, this.y);
    }
    public void setY(float y){
        setPos(x, this.y);
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

}
