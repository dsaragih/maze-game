package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.graph.PlanarGraph;
import com.mygdx.game.graph.PlanarNode;
import com.mygdx.game.graph.TestGraphGenerator;
import com.mygdx.game.graphics.IPresenter;
import com.mygdx.game.graphics.door.IDoorDrawer;
import com.mygdx.game.graphics.room.IRoomDrawer;
import org.graalvm.compiler.nodes.calc.IntegerEqualsNode;

import java.util.*;

public class Level {
    private Collection<Room> rooms;
    private Room currentRoom;
    private ILevelDrawer levelDrawer;
    public Level(IPresenter presenter){
        levelDrawer = presenter.getLevelDrawer();
        IDoorDrawer doorDrawer = presenter.getDoorDrawer();
        IRoomDrawer roomDrawer = presenter.getRoomDrawer();

        PlanarGraph levelLayout = new TestGraphGenerator().generate();
        Map<Set<PlanarNode>, Boolean> edges = getEdgeMap(levelLayout);
        Map<PlanarNode, Room> nodeToRoom = new HashMap<>();
        for(PlanarNode node: levelLayout){
            nodeToRoom.put(node, new Room(roomDrawer, entityDrawer));
        }

        for (PlanarNode node: levelLayout) {
            for (PlanarNode neighbour: node.getNeighboors()){
                Set<PlanarNode> pair = new HashSet<>();
                pair.add(node);
                pair.add(neighbour);
                if(!edges.get(pair)){
                    Room r1 = nodeToRoom.get(node);
                    Room r2 = nodeToRoom.get(neighbour);

                    Door door1 = new Door(doorDrawer);
                    Door door2 = new Door(doorDrawer);

                    door1.setRoom(r1);
                    door2.setRoom(r2);

                    door1.setDoor(door2);
                    door2.setDoor(door1);

                    r1.addDoor(door1);
                    r2.addDoor(door2);

                    edges.put(pair, true);
                }
            }
        }

        rooms = nodeToRoom.values();
        currentRoom = rooms.iterator().next();
    }

    public void update(Player player){
        currentRoom = currentRoom.update(player);
    }

    public void draw(){
        levelDrawer.drawLevel(currentRoom);
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
