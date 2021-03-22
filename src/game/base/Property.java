package game.base;

public abstract class Property extends Entity {
    public abstract Integer value();

    public abstract void change(long delta);
}