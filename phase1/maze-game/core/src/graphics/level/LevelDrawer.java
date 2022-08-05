package graphics.level;

import entities.Room;

public class LevelDrawer implements ILevelDrawer{
    @Override
    public void drawLevel(Room room) {
        room.draw();
    }
}
