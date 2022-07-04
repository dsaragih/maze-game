package g0241.graph;
import g0241.Point;

import java.util.HashSet;
import java.util.Set;

public class PlanarNode extends Point {

    private Set<PlanarNode> neighbors;


    public PlanarNode(float x, float y){
        super(x,y);
        neighbors = new HashSet<PlanarNode>();

    }

    public void add_neighbor(PlanarNode node){
        neighbors.add(node);
    }
}
