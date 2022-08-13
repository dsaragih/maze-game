import geometry.*;
import org.junit.*;

import static org.junit.Assert.*;

public class GeometryTest {

    @Test(timeout = 50)
    public void pointLengthTest(){
        final Point p1 = new Point(3,4);
        final double expectedLength = 5.0;
        final double actualLength = p1.length();
        assertEquals(expectedLength, actualLength, 0.01);
    }

    @Test(timeout = 50)
    public void distanceVectorTest(){
        final Point p1 = new Point(3,4);
        final Point p2 = new Point(6,7);
        final Point distanceVector = p1.distanceVector(p2);
        final double expected_x = -3.0;
        final double expected_y = -3.0;
        final double actual_x = distanceVector.getX();
        final double actual_y = distanceVector.getY();
        assertEquals(expected_x,actual_x, 0.01);
        assertEquals(expected_y,actual_y, 0.01);
    }

    @Test(timeout = 50)
    public void circleIntersectionTest1(){
        final Circle c1 = new Circle(new Point(1,2), 2);
        final Circle c2 = new Circle(new Point(1,7), 3);
        final Boolean expected = true;
        final Boolean actual = c1.intersects(c2);
        assertEquals(expected, actual);
    }
    @Test(timeout = 50)
    public void circleIntersectionTest2(){
        final Circle c1 = new Circle(new Point(1,2), 2);
        final Circle c2 = new Circle(new Point(1,10), 3);
        final Boolean expected = false;
        final Boolean actual = c1.intersects(c2);
        assertEquals(expected, actual);
    }
}
