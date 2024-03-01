package src;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Calculate> classes = new ArrayList<>();

        for (int y = 0; y < 5; y++) {
            Calculate c = new Calculate();
            classes.add(c);
            Thread t = new Thread(c);
            threads.add(t);
            t.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All threads finished");

        for (Calculate c : classes) {
            System.out.println(c.getVal());
        }
    }
}
