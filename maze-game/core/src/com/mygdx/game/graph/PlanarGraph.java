package com.mygdx.game.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PlanarGraph implements Iterable<PlanarNode>{

    private Set<PlanarNode> nodes = new HashSet<PlanarNode>();

    public void addNode(PlanarNode node) {
        nodes.add(node);
    }

    public void joinDirected(PlanarNode n1, PlanarNode n2) {
        n1.addNeighbor(n2);
    }

    public void joinUndirected(PlanarNode n1, PlanarNode n2) {
        joinDirected(n2, n1);
        joinDirected(n1, n2);
    }

    @Override
    public Iterator<PlanarNode> iterator() {
        return nodes.iterator();
    }
}
