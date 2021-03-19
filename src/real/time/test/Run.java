package real.time.test;

import real.time.Loop;

public class Run {
    public static void main(String[] args) {
        Loop loop = new Loop();
        Test testLoopBody = new Test();
        try {
            loop.loop(testLoopBody.getAction());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}