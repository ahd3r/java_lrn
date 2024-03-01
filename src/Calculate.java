package src;

public class Calculate implements Runnable {
    private int val = 0;

    public void run () {
        for (int y = 0; y < 10; y++) {
            val = 0;
            for (int i = 0; i < 2147483647; i++) {
                val += i;
            }
        }
    }

    public int getVal() {
        return val;
    }
}
