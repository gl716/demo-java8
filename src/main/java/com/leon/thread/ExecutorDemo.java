package com.leon.thread;

import java.util.concurrent.*;

/**
 * @author Leon
 * @since 2021年08月19日 8:50
 **/
public class ExecutorDemo {

    public static void main(String[] args) {
        //new ScheduledThreadPoolExecutor()
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> schedule = executorService.schedule(() -> System.out.println("123"), 100, TimeUnit.MILLISECONDS);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        schedule.cancel(true);
    }
}
