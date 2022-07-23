package com.mygdx.game.graph;
import java.util.ArrayList;
public class PolygonGenerator{
    public PlanarGraph generate(Point center, int n, float radius, float angle){

        // generate cycle
        PlanarGraph graph = new PlanarGraph();
        //Convert to radian
        float initialRadian = Math.toRadians(angle);
        float radianIncrement = Math.toRadians(360.0/n);
        ArrayList<PlanarNode> lst = new ArrayList<PlanarNode>();
        //Create the vertices
        for (int i=0; i<n; i++){
            PlanarNode n1 = new PlanarNode(center.x+radius*(float)Math.cos(initialRadian+radianIncrement),
                    center.y+radius*(float)Math.sin(angle));
            lst.add(n1);
        }
        //Join undirected edges
        for (int i=0: i<n;i++){
            PlanarNode n1 = lst.get(i%n);
            PlanarNode n2 = lst.get((i+1)%n);
            n1.joinUndirected(n2);
        }
        //Add nodes to graph
        for(PlanaNode node: lst){
            graph.addNode(node);
        }

        return graph;
    }

}
