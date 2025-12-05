package common;

public abstract class Problem {
    public void run() {
        System.out.println("solution:");
        long start = System.nanoTime();
        solve();
        endTheClock(start);
    }

    public void runSimple() {
        System.out.println("simple solution:");
        long start = System.nanoTime();
        solveSimple();
        endTheClock(start);
    }

    public void runDummy() {
        long start = System.nanoTime();
        endTheClock(start);
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
        runDummy();
        runSimple();
        System.out.println();
        run();  //run hier schneller?!?!
    }

    protected abstract void solveSimple();

    protected abstract void solve();
}
