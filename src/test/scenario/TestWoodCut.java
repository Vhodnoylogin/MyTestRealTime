package test.scenario;

import real.time.Loop;
import test.entities.actions.Cut;
import test.entities.character.Tree;
import test.entities.character.Woodcutter;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class TestWoodCut {
    protected Tree tree;
    protected Woodcutter woodcutter;
    protected Cut cut;

    protected BiConsumer<Double, Loop.StopLoop> action;

    protected Function<Tree, Double> getPercentHealth = (tree) ->
            tree.getHealth().getPropertyValue()
                    / tree.getHealth().getPropertyValueInit();

    protected Consumer<Tree> show0 = (tree) -> {
        if (getPercentHealth.apply(tree) < 0.0) {
            System.out.println("Alarm 0%!!!!!!!!!");
            System.out.println(
                    "Health = "
                            + tree.getHealth().getPropertyValue()
            );
            show = (x) -> {
            };
        }
    };
    protected Consumer<Tree> show30 = (tree) -> {
        if (getPercentHealth.apply(tree) < 0.3) {
            System.out.println("Alarm 30%!!!!!!");
            System.out.println(
                    "Health = "
                            + tree.getHealth().getPropertyValue()
            );
            show = show0;
        }
    };
    protected Consumer<Tree> show50 = (tree) -> {
        if (getPercentHealth.apply(tree) < 0.5) {
            System.out.println("Alarm 50%!!!");
            System.out.println(
                    "Health = "
                            + tree.getHealth().getPropertyValue()
            );
            show = show30;
        }
    };
    protected Consumer<Tree> show70 = (tree) -> {
        if (getPercentHealth.apply(tree) < 0.7) {
            System.out.println("Alarm 70%!");
            System.out.println(
                    "Health = "
                            + tree.getHealth().getPropertyValue()
            );
            show = show50;
        }
    };
    protected Consumer<Tree> show100 = (tree) -> {
        if (getPercentHealth.apply(tree) > 0.9) {
            System.out.println("Alarm 100%!");
            System.out.println(
                    "Health = "
                            + tree.getHealth().getPropertyValue()
            );
            show = show70;
        }
    };
    protected Consumer<Tree> show = show100;

    protected BiConsumer<Tree, Loop.StopLoop> stop = (tree, stop) -> {
        if (tree.getHealth().getPropertyValue() < 0.0) {
            stop.stop();
        }
    };

    {
        tree = new Tree();
        woodcutter = new Woodcutter();

        cut = new Cut();
        cut.setCuttingHealth(tree.getHealth());
        cut.setStrength(woodcutter.getStrength());

        this.action = (delta, cycle) -> {
            show.accept(tree);
            stop.accept(tree, cycle);
            cut.calc(delta);
        };
    }

    public BiConsumer<Double, Loop.StopLoop> getAction() {
        return action;
    }
}