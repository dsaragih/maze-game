package entities;

import com.badlogic.gdx.math.MathUtils;
import entities.Door;
import entities.Gun;
import entities.Player;
import geometry.Point;
import graph.PlanarGraph;
import graph.PlanarNode;
import graph.TestGraphGenerator;
import graphics.IPresenter;
import graphics.door.IDoorDrawer;
import graphics.level.ILevelDrawer;
import manager.EntityManager;
import manager.IEntityManager;

import java.util.*;

/**
 * Represents a level
 * @author Daniel
 * @author Ethan
 */
public class Level implements IRoomContainer {
    private Room currentRoom;
    private ILevelDrawer levelDrawer;
    private Random rnd = new Random();
    private int screenWidth;
    private int screenHeight;
    private Player player;

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
        //this line of code is for convenience of testing
//        currentRoom = new entities.BossRoom(presenter, player, screenWidth, screenHeight);

        addMerchantToRooms(new ArrayList<>(rooms));

        gun.setEntityManager(currentRoom.getEntityManager());
    }

    /**
     * Set a new room
     * @param room a room that will be in container.
     */
    public void setNewRoom(Room room){

        IEntityManager entityManager = currentRoom.getEntityManager();
        if (entityManager.isFinished()){
        currentRoom = room;
        player.setGunEntityManager(currentRoom.getEntityManager());
        player.setCollideWithMerchant();
        }
    }
    private void addMerchantToRooms(List<Room> rooms) {
        int merchant1Index = MathUtils.random(0, rooms.size() - 1);
        int merchant2Index = MathUtils.random(0, rooms.size() - 1);
        while (merchant2Index == merchant1Index) merchant2Index = MathUtils.random(0, rooms.size() - 1);

        rooms.get(merchant1Index).addMerchant();
        rooms.get(merchant2Index).addMerchant();
    }
    /**
     * Update the current room
     */
    public void update(){
        EntityManager entityManager = (EntityManager) currentRoom.getEntityManager();
        currentRoom.update();
        if (entityManager.isFinished()){player.changeGold(entityManager.getGold());}
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


    public Player getPlayer(){return player;}

}
