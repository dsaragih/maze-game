import graph.PlanarGraph;
import graph.PlanarNode;
import geometry.Point;
import graph.PolygonGenerator;
import static org.junit.Assert.*;
import org.junit.Test;

public class GraphGeneratorTest {

    @Test(timeout = 50)
    public void mergeGraphTest(){
        final PlanarGraph p1 = new PlanarGraph();
        final PlanarGraph p2 = new PlanarGraph();
        final PlanarNode n1 = new PlanarNode(-1,-2);
        final PlanarNode n2 = new PlanarNode(2,-2);
        final PlanarNode n3 = new PlanarNode(1,-1);
        final PlanarNode n4 = new PlanarNode(4,-1);
        final PlanarNode n5 = new PlanarNode(-2,0);
        final PlanarNode n6 = new PlanarNode(0,0);
        p1.addNode(n1);
        p1.addNode(n2);
        p1.addNode(n3);
        p2.addNode(n4);
        p2.addNode(n5);
        p2.addNode(n6);
        p1.mergeGraph(p2);
        assertTrue(p1.getNodes().contains(n4));
    }
    @Test(timeout = 50)
    public void joinUndirectedNodesTest(){
        final PlanarNode n1 = new PlanarNode(-1,-2);
        final PlanarNode n2 = new PlanarNode(2,-2);
        n1.joinUndirected(n2);
        assert n1.getNeighbors().contains(n2);
        assert n2.getNeighbors().contains(n1);
    }
    @Test(timeout = 50)
    public void polygonGraphGeneratorTest(){
        final PolygonGenerator p = new PolygonGenerator(new Point(0,0), 2,1, 0);
        final PlanarGraph g = p.generate();
        boolean containsLeftPoint = false;
        boolean containsRightPoint = false;
        for (final PlanarNode planarNode : g.getNodes()) {
            if (Math.abs(planarNode.getX() - 1) < 0.01 && Math.abs(planarNode.getY() - 0) < 0.01) {
                containsLeftPoint = true;
                break;
            }
        }
        for (final PlanarNode planarNode : g.getNodes()) {
            if (Math.abs(planarNode.getX() + 1) < 0.01 && Math.abs(planarNode.getY() - 0) < 0.01) {
                containsRightPoint = true;
                break;
            }
        }
        assertTrue(containsLeftPoint);
        assertTrue(containsRightPoint);
    }

}