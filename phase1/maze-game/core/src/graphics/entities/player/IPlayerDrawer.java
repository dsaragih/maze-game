package graphics.entities.player;

import geometry.Point;

public interface IPlayerDrawer {
    void drawPlayer(Point pos, Point gunDirection);
    Point getGunPos(Point playerPos, Point gunDirection);
}
