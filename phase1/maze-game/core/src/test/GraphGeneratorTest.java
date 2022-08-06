import graph.PlanarGraph;
import graph.PlanarNode;
import geometry.Point;
import graph.PolygonGenerator;
import org.junit.*;

import static org.junit.Assert.*;
import org.junit.Test;
public class GraphGeneratorTest {

    @Test(timeout = 50)
    public void mergeGraphTest(){
        PlanarGraph p1 = new PlanarGraph();
        PlanarGraph p2 = new PlanarGraph();
        PlanarNode n1 = new PlanarNode(-1,-2);
        PlanarNode n2 = new PlanarNode(2,-2);
        PlanarNode n3 = new PlanarNode(1,-1);
        PlanarNode n4 = new PlanarNode(4,-1);
        PlanarNode n5 = new PlanarNode(-2,0);
        PlanarNode n6 = new PlanarNode(0,0);
        p1.addNode(n1);
        p1.addNode(n2);
        p1.addNode(n3);
        p2.addNode(n1);
        p2.addNode(n2);
        p2.addNode(n3);
        p1.mergeGraph(p2);
        assert p1.getNodes().contains(n4);
    }
    @Test(timeout = 50)
    public void joinUndirectedNodesTest(){
        PlanarNode n1 = new PlanarNode(-1,-2);
        PlanarNode n2 = new PlanarNode(2,-2);
        n1.joinUndirected(n2);
        assert n1.getNeighboors().contains(n2);
        assert n2.getNeighboors().contains(n1);
    }
//    public void polygonGraphGeneratorTest(){
//        PolygonGenerator p = new PolygonGenerator(new Point(0,0), 4,1.0, 1.0);
//        PlanarGraph g = p.generate();
//        Boolean expected = true;
//        Boolean actual;
//        for (PlanarNode i: g.getNodes()) {
//
//        }
//    }

}