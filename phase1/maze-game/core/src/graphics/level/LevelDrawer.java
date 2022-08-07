package graphics.level;

import entities.rooms.Room;

public class LevelDrawer implements ILevelDrawer{
    @Override
    public void drawLevel(Room room) {
        room.draw();
    }
}
