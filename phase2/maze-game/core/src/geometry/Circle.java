package geometry;

/**
 * Represents a circle
 * @author Ethan
 */
public class Circle {
    private final Point center;
    private final float radius;

    /**
     * Create a circle
     * @param center the center point
     * @param radius the radius
     */
    public Circle(final Point center, final float radius){
        this.center = center;
        this.radius = radius;
    }

    /**
     * Determine whether two circles are intersected
     * @param other the other circle
     * @return whether two circles are intersected
     */
    public boolean intersects(final Circle other){
        final Point dist = center.distanceVector(other.center);
        return dist.length() <= radius + other.radius;
    }
    public Point getCenter(){
        return center;
    }
}
