package test.entities.base;

import java.util.function.Consumer;

public class Action extends Entity {
    //    protected Function<Double,Double> action;
    protected Consumer<Double> action;

    public void calc(Double delta) {
//        action.apply(delta);
        action.accept(delta);
    }
}