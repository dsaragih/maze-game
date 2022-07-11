package com.mygdx.game.graph;

import com.mygdx.game.Point;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PlanarNode extends Point {
    private Set<PlanarNode> neighbors;
    public PlanarNode(float x, float y){
        super(x,y);
        neighbors = new HashSet<PlanarNode>();
    }

    public Set<PlanarNode> getNeighboors(){
        return neighbors;
    }

    public void addNeighbor(PlanarNode node){
        neighbors.add(node);
    }

    public static void joinUndirected(PlanarNode n1, PlanarNode n2){
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
