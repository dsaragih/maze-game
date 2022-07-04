package g0241.graph;


public class GraphGenerator {



    public PlanarGraph<PlanarNode> generate_cycle(){

        // generate cycle

        PlanarGraph<PlanarNode> graph = new PlanarGraph<PlanarNode>();

        float avg_rotation = 1.0f, avg_radius = 1.0f;

        float theta = 0, r = 0;

        PlanarNode n0 = new PlanarNode(r*Math.cos(theta), r*Math.sin(theta);

        while (theta < 2*Math.PI) {
            theta += Math.random()*avg_rotation;
            r += (float)Math.random()*avg_radius;
            PlanarNode n1 = new PlanarNode(r*(float)Math.cos(theta), r*(float)Math.sin(theta);
            graph.addNode(n1);
            graph.joinUndirected(n0,n1);
        }


        return graph;



    }






}