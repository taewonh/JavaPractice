package etc.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompletableFutureTest {

    @Test
    @DisplayName("반환값이 있는 비동기 작업 실행")
    public void supplyAsyncTest() throws ExecutionException, InterruptedException {
        String hello = "Hello";
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("running supply async thread : " + Thread.currentThread().getName());
            return hello;
        });
        String returnValue = future.get();
        Assertions.assertEquals(hello, returnValue);
        System.out.println("main test thread : " + Thread.currentThread().getName());
    }

    @Test
    @DisplayName("반환값이 없는 비동기 작업 실행")
    public void runAsyncTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("Hello"));
//        future.get();
    }

    @Test
    public void chainTest() {
        String taewon = "taewon";
        CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("supplyAsync");
                    return taewon;
                })
                .thenApplyAsync(accept -> {
                    System.out.println("thenApplyAsync" + accept);
                    return accept + " hi";
                })
                .thenAcceptAsync(accept -> {
                    System.out.println("thenAcceptAsync" + accept);
                });

    }
}
