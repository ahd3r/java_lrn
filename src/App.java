package src;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        int res = 0;
        for (int y = 0; y < 15; y++) {
            res = 0;
            for (int i = 0; i < 2147483647; i++) {
                res += i;
            }
        }
        System.out.println("Main thread finished");
        System.out.println(res);
        System.out.println("Other threads are about to start");

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
