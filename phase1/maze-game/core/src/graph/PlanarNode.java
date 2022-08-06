package graph;

import geometry.Point;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a planar node
 * @author Ethan
 * @author Jack Sun
 */
public class PlanarNode extends Point {
    private Set<PlanarNode> neighbors;

    /**
     * Create a planar node
     * @param x x-coordinate of node
     * @param y y-coordinate of node
     */
    public PlanarNode(double x, double y){
        super(x,y);
        neighbors = new HashSet<PlanarNode>();
    }

    /**
     * Get all adjacent nodes
     * @return set of all adjacent nodes.
     */
    public Set<PlanarNode> getNeighboors(){
        return neighbors;
    }

    /**
     * Add a neighbour
     * @param node node being added
     */
    public void addNeighbor(PlanarNode node){
        neighbors.add(node);
    }

    /**
     * Join two nodes with undirected edge
     * @param n2 node to be joined
     */
    public void joinUndirected(PlanarNode n2){
        this.addNeighbor(n2);
        n2.addNeighbor(this);
//        n1.addNeighbor(n2);
//        n2.addNeighbor(n1);
    }

    /**
     * Determine whether the point equals the object
     * @param ob the object being compared
     * @return
     */
    @Override
    public boolean equals(Object ob)
    {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        PlanarNode n = (PlanarNode) ob;
        return x == n.x && y == n.y;
    }

    /**
     * Retrun integer hash code of the coordinate of the node
     * @return hash code of the coordinate of the node
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
