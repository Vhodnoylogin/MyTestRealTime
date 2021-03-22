package real.time;

import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class Loop {
    protected Integer delta = 30;
    protected StopLoop stop = new StopLoop(this);

    public void loop(BiConsumer<Double, StopLoop> actions) throws InterruptedException {
        Double delta = 1000.0 / this.delta;
        while (!this.stop.stopLoop()) {
            actions.accept(delta / 1000, this.stop);
            TimeUnit.MILLISECONDS.sleep(delta.longValue());
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