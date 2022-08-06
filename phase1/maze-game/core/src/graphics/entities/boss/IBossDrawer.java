package graphics.entities.boss;

import geometry.Point;

public interface IBossDrawer {
    void drawBoss(Point pos);
    void setRadius(int radius);
}
