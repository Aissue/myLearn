package main;

import java.util.concurrent.Semaphore;

/**
 * @author yscredit
 */
public class myMain {
    private static Semaphore semaphore = new Semaphore(1);
    public static void main(String[] args) throws InterruptedException {
        semaphore.acquire();
        System.out.println("myMain is running...");
        System.out.println("myMain is running...");
        System.out.println("myMain is running...");
        semaphore.acquire();

        //test一下
    }
}
