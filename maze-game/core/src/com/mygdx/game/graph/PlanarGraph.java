package com.mygdx.game.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PlanarGraph implements Iterable<PlanarNode>{

    private Set<PlanarNode> nodes = new HashSet<PlanarNode>();

    public Set<PlanarNode> getNodes(){
        return this.nodes;
    }

    public void addNode(PlanarNode node) {
        nodes.add(node);
    }

    public void addDirectedEdge(PlanarNode n1, PlanarNode n2) {
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(PlanarNode n1, PlanarNode n2) {
        this.addDirectedEdge(n2, n1);
        this.addDirectedEdge(n1, n2);
    }

    public void mergeGraph(PlanarGraph g1){
        for (PlanarNode node: g1.getNodes()){
            this.addNode(node)
        }
    }

    @Override
    public Iterator<PlanarNode> iterator() {
        return nodes.iterator();
    }
}
