package com.mygdx.game;

import com.mygdx.game.Entities.Door;
import com.mygdx.game.Entities.Gun;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.geometry.Point;
import com.mygdx.game.graph.PlanarGraph;
import com.mygdx.game.graph.PlanarNode;
import com.mygdx.game.graph.TestGraphGenerator;
import com.mygdx.game.graphics.IPresenter;
import com.mygdx.game.graphics.door.IDoorDrawer;
import com.mygdx.game.graphics.level.ILevelDrawer;

import java.util.*;

/**
 * Represents a level
 * @author Daniel
 * @author Ethan
 */
public class Level implements IRoomContainer {
    private Room currentRoom;
    private final ILevelDrawer levelDrawer;
    private final Random rnd = new Random();
    private final int screenWidth;
    private final int screenHeight;
   private final Player player;

    /**
     * Create a alevel
     * @param presenter the presenter in Clean architecture
     * @param player a player instance
     * @param screenWidth the width of screen
     * @param screenHeight the height of screen
     */
    public Level(IPresenter presenter, Player player, int screenWidth, int screenHeight){
        this.player = player;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        Gun gun = new Gun(new Point(screenWidth / 2f, screenHeight / 2f), presenter.getGunDrawer(), presenter.getBulletDrawer());
        player.setGun(gun);

        levelDrawer = presenter.getLevelDrawer();


        PlanarGraph levelLayout = new TestGraphGenerator().generate();
        Map<Set<PlanarNode>, Boolean> edges = getEdgeMap(levelLayout);
        Map<PlanarNode, Room> nodeToRoom = new HashMap<>();
        for(PlanarNode node: levelLayout){
            nodeToRoom.put(node, new Room(presenter, player, screenWidth, screenHeight));
        }

        for (PlanarNode node: levelLayout) {
            for (PlanarNode neighbour: node.getNeighboors()){
                Set<PlanarNode> pair = new HashSet<>();
                pair.add(node);
                pair.add(neighbour);
                if(!edges.get(pair)){
                    Room r1 = nodeToRoom.get(node);
                    Room r2 = nodeToRoom.get(neighbour);

                    IDoorDrawer doorDrawer = presenter.getDoorDrawer();
                    Door door1 = new Door(getRandomPointOnScreen(), doorDrawer, this);
                    Door door2 = new Door(getRandomPointOnScreen(), doorDrawer, this);

                    door1.setRoom(r1);
                    door2.setRoom(r2);

                    door1.setCorrespondingDoor(door2);
                    door2.setCorrespondingDoor(door1);
                    r1.addDoor(door1);
                    r2.addDoor(door2);


                    edges.put(pair, true);
                }
            }
        }

        Collection<Room> rooms = nodeToRoom.values();
        currentRoom = rooms.iterator().next();
        gun.setEntityManager(currentRoom.getEntityManager());
    }

    /**
     * Set a new room
     * @param room a room that will be in container.
     */
    public void setNewRoom(Room room){

        // For some reason this is being called more than once if the Player walks through a door.
        IEntityManager entityManager = currentRoom.getEntityManager();
        if (entityManager.isFinished()){
        currentRoom = room;
        player.setGunEntityManager(currentRoom.getEntityManager());}
    }

    /**
     * Update the current room
     */
    public void update(){
        currentRoom.update();
    }

    /**
     * Draw the level
     */
    public void draw(){
        levelDrawer.drawLevel(currentRoom);
    }

    /**
     * Return an edge map
     * @param levelLayout the layout of level
     * @return a map of edges
     */
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

    /**
     * Generate a random point
     * @return a random point on screen
     */
    private Point getRandomPointOnScreen(){
        return new Point(rnd.nextInt(screenWidth), rnd.nextInt(screenHeight));
    }

    /**
     * Move player in a given direction
     * @param dir direction
     */
    public void movePlayer(Point dir){
        player.move(dir);
    }

    /**
     * Update the position of mouse
     * @param mousePos position of mouse
     */
    public void setMousePos(Point mousePos){
        player.setMousePos(mousePos);
    }

    /**
     * Click mouse to fire
     * @param mouseDir direction of fire
     */
    public void mouseClick(Point mouseDir){
        player.fire(mouseDir);
    }

    /*
    * Returns tru if player is dead, false otherwise
    * */
    public boolean isOver(){
        return player.getHealth() <= 0;
    }
}
