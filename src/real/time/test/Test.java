package real.time.test;

import real.time.Loop;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Test {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Loop loop = new Loop();
        AtomicLong it = new AtomicLong(0L);
        Random rand = new Random();

        int min = 10;
        int max = 20;
        int diff = max - min + 1;
        try {
            loop.loop((delta, cycle) -> {
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
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}