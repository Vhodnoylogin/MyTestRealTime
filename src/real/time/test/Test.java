package real.time.test;

import real.time.Loop;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

public class Test {
    protected BiConsumer<Long, Loop.StopLoop> action;

    {
        long startTime = System.nanoTime();
        AtomicLong it = new AtomicLong(0L);
        Random rand = new Random();

        int min = 10;
        int max = 20;
        int diff = max - min + 1;

        this.action = (delta, cycle) -> {
            long iit = it.get();
            long time = System.nanoTime();
            int randInt = rand.nextInt(diff) + min;
            String out = ""
                    + (iit++) + "\n"
                    + (iit * delta) + " : " + (time - startTime) / 1000000 + "\n"
                    + randInt + "\n"
                    + "\n";
            System.out.println(out);
            it.set(iit);
            if (randInt % 7 == 0) {
                cycle.stop();
            }
        };
    }

    public BiConsumer<Long, Loop.StopLoop> getAction() {
        return action;
    }
}