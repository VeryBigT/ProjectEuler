package common;

public abstract class Problem {
    public void run() {
        long start = startTheClock("Solution:");
        solve();
        endTheClock(start);
    }

    public void runSimple() {
        long start = startTheClock("Simple solution:");
        solveSimple();
        endTheClock(start);
    }

    private long startTheClock(String s) {
        System.out.println(s);
        return System.nanoTime();
    }

    private void endTheClock(long start) {
        long end = System.nanoTime();
        long duration = end - start;
        String durationString = duration > 1_000_000_000L
                ? String.format("%d.%d sec", duration / 1_000_000_000L, duration % 1_000_000_000L)
                : duration > 1_000_000L
                ? String.format("%d.%d ms", duration / 1_000_000L, duration % 1_000_000L / 10_000L)
                : duration > 1_000L
                ? String.format("%d.%d µs", duration / 1_000L, duration % 1_000L / 10L)
                : duration + " ns";
        System.out.println("calculated in " + durationString);
    }

    public void runBoth() {
        runSimple();
        System.out.println();
        run();  //run hier schneller?!?!
    }

    protected abstract void solveSimple();

    protected abstract void solve();
}
