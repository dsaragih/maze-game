package graphics.entities.player;

import geometry.Point;

public interface IPlayerDrawer {
    public void drawPlayer(Point pos, Point gunDirection);
    public Point getGunPos(Point playerPos, Point gunDirection);
}
