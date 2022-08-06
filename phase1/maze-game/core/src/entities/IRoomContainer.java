package entities;

import entities.Room;

/**
 * Represents a room container interface
 * @author Ethan
 */
public interface IRoomContainer {

    /**
     * Set a new room
     * @param room a room that will be in container.
     */
    void setNewRoom(Room room);
}
