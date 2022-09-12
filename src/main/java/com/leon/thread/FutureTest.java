package com.leon.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @author Leon
 * @since 2022年06月22日 9:41
 **/
@Slf4j
public class FutureTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            if (Math.random() < 0.3) {
                throw new RuntimeException("fetch price failed!");
            }
            return 5 + Math.random() * 20;
        });
        // 如果执行成功:
        cf.thenAccept(FutureTest::printResult);
        // 如果执行异常:
        cf.exceptionally(FutureTest::handleEx);


        CompletableFuture<String> getCode = CompletableFuture.supplyAsync(() -> "123");
        CompletableFuture<Double> getDouble = getCode.thenApplyAsync((code) -> 5 + Math.random() * 20);
        getDouble.thenAccept(System.out::println);

        CompletableFuture<String> async1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "123";
        });
        CompletableFuture<String> async2 = CompletableFuture.supplyAsync(() -> "456");
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(async1, async2);
        CompletableFuture<Integer> f1 = objectCompletableFuture.thenApplyAsync((code) -> Integer.parseInt(code.toString()));
        CompletableFuture<Double> f2 = objectCompletableFuture.thenApplyAsync((code) -> Double.parseDouble(code.toString()));
        CompletableFuture<Object> objectCompletableFuture1 = CompletableFuture.anyOf(f1, f2);
        objectCompletableFuture1.thenAccept((o)->{
            System.out.println(o.getClass());
            System.out.println(o);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }

    static void printResult(Double result){
        log.info("price: " + result);
    }

    static Double handleEx(Throwable e){
        e.printStackTrace();
        return null;
    }
}
