package g0241.levelAndRooms;

import g0241.ent.Entity;
import g0241.graph.GraphGenerator;
import g0241.graph.PlanarGraph;
import g0241.graph.PlanarNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Level {
    //A level should be ordered in different levels, it used the graph to generated it each time
    public PlanarGraph<PlanarNode> localLevel = new GraphGenerator().generate_cycle();
    //the static variable order keep track of the number of level instantiated
    public static int order = 1;
    private final int currentLevel = order;
    private ArrayList<Room> rooms;
    //In the constructor, the room will be generated as the nodes of the randomly generated graph.
    //The player will be generated in the first room while the boss will be generated in the last room.
    public Level(){
        order++;
        Set<PlanarNode> nodes = localLevel.getNodes();
        for (Iterator<PlanarNode> it = nodes.iterator(); it.hasNext(); ) {

            PlanarNode node = it.next();
        }

            //need a getter to update the room according to the nodes generated.
        }
    public int getCurrentLevel(){return currentLevel;}
}
