package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.graph.GraphGenerator;
import com.mygdx.game.graph.PlanarGraph;
import com.mygdx.game.graph.PlanarNode;
import com.mygdx.game.graph.TestGraphGenerator;

import java.util.*;

public class Level {
    private Collection<Room> rooms;
    private Room currentRoom;
    public Level(){
        PlanarGraph levelLayout = new TestGraphGenerator().generate();
        Map<Set<PlanarNode>, Boolean> edges = getEdgeMap(levelLayout);
        Map<PlanarNode, Room> nodeToRoom = new HashMap<>();
        for(PlanarNode node: levelLayout){
            nodeToRoom.put(node, new Room());
        }

        for (PlanarNode node: levelLayout) {
            for (PlanarNode neighbour: node.getNeighboors()){
                Set<PlanarNode> pair = new HashSet<>();
                pair.add(node);
                pair.add(neighbour);
                if(!edges.get(pair)){
                    Room r1 = nodeToRoom.get(node);
                    Room r2 = nodeToRoom.get(neighbour);
                    Door door = new Door(r1, r2);
                    r1.addDoor(door);
                    r2.addDoor(door);
                    edges.put(pair, true);
                }
            }
        }

        rooms = nodeToRoom.values();
        currentRoom = rooms.iterator().next();
    }

    public void update(Player player){
        currentRoom.update(player);
    }

    public void draw(ShapeRenderer shapeRenderer){
        currentRoom.draw(shapeRenderer);
    }

    private Map<Set<PlanarNode>, Boolean> getEdgeMap(PlanarGraph levelLayout){
        Map<Set<PlanarNode>, Boolean> edges = new HashMap<>();
        for(PlanarNode n1: levelLayout){
            for(PlanarNode n2: levelLayout){
                Set<PlanarNode> pair = new HashSet<>();
                pair.add(n1);
                pair.add(n2);
                if(n1 != n2 && !edges.containsKey(pair) && n1.getNeighboors().contains(n2)){
                    edges.put(pair, false);
                }
            }
        }

        return edges;
    }
}
