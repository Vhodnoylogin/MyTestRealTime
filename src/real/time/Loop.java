package real.time;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

public class Loop {
    protected Integer delta = 30;
    protected StopLoop stop = new StopLoop(this);

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
                        + "\n"
                        ;
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

    public void loop(BiConsumer<Long, StopLoop> actions) throws InterruptedException {
        long delta = 1000 / this.delta;
        while (!this.stop.stopLoop()) {
            actions.accept(delta, this.stop);
            TimeUnit.MILLISECONDS.sleep(delta);
        }
    }

    public static class StopLoop {
        protected Loop cycle;
        protected boolean stopFlag = false;

        public StopLoop(Loop cycle) {
            this.cycle = cycle;
        }

        public void stop() {
            this.stopFlag = true;
        }

        protected boolean stopLoop() {
            return this.stopFlag;
        }
    }
}