package g0241.PlayerInput.Keys;

public interface Key {
    //i'm almost sure there's some better way to do this because i don't want to keep adding key classes,
    //but for now this will have to do until i come up with something better (feel free to leave suggestions)
    void pressedAction();
    void releasedAction();
    void typedAction();
}
