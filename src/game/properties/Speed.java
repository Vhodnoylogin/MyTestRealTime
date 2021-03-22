package game.properties;

import game.base.Property;

public class Speed extends Property {
    protected Integer speed;

    @Override
    public Integer value() {
        return speed;
    }

    @Override
    public void change(long delta) {
    }
}