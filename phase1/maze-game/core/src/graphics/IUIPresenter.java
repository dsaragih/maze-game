package graphics;

import graphics.presenters.IDrawble;

public interface IUIPresenter extends IDrawble {
    public void draw();

    public void updatePlayerShield(int playerShield);
    public void updateIsGameOver(boolean isLevelOver);
    public void updatePlayerGold(int playerGold);
    public void dispose();
}
