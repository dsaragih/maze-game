package g0241.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlanarGraph <T extends PlanarNode> {

    private Set<T> nodes;

    public PlanarGraph(){
        nodes = new HashSet<T>();
    }

    public void addNode(T node) {
        nodes.add(node);
    }

    public void joinDirected(T n1, T n2){
        n1.add_neighbor(n2);
    }

    public void joinUndirected(T n1, T n2){
        joinDirected(n2,n1);
        joinDirected(n1,n2);
    }

    public void check_planarity(){
        //TOOO probably just like check

    }




}

