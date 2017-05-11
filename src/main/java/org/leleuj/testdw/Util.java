package org.leleuj.testdw;

public final class Util {

    public static void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            // ignore
        }
    }

    public static int random(final int max) {
        return (int) (Math.random() * (double) max);
    }
}
