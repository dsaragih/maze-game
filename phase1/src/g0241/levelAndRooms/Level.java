package g0241.levelAndRooms;

import g0241.graph.GraphGenerator;
import g0241.graph.PlanarGraph;

import java.util.ArrayList;

public class Level {
    //A level should be ordered in different levels, it used the graph to generated it each time
    public PlanarGraph localLevel = new GraphGenerator().generateCycle();
    public static int order = 0;
    private ArrayList<Room> rooms;
    //In the constructor, the room will be generated as the nodes of the randomly generated graph
    public Level(){
        order++;
        //need a getter to update the room according to the nodes generated.
    }
}
