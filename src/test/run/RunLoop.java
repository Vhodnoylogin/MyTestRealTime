package test.run;

import real.time.Loop;
import test.scenario.TestWoodCut;

public class RunLoop {
    public static void main(String[] args) {
        Loop loop = new Loop();
        TestWoodCut testLoopBody = new TestWoodCut();
        try {
            loop.loop(testLoopBody.getAction());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}