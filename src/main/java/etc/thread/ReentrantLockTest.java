package etc.thread;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockTest {
    private final ReentrantLock lock = new ReentrantLock();
    private final int totalCount = 15;
    private int currentCount = 0;
    private final int sleepTime = 1000;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest lockTest = new ReentrantLockTest();
        List<Callable<Void>> jobs = lockTest.generateJobs();
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        LocalDateTime startTime = LocalDateTime.now();
        executorService.invokeAll(jobs);

        while (true) {
            if (lockTest.currentCount == 15) {
                executorService.shutdown();
                break;
            }
        }
        LocalDateTime endTime = LocalDateTime.now();
        Duration between = Duration.between(startTime, endTime);
        System.out.println(between.getSeconds() + "초");
    }

    private Callable<Void> generateJob(int count) {
        return () -> {
            try {
                lock.lock();
                Thread.sleep(sleepTime);
                System.out.println("sleep job: " + count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                currentCount++;
                lock.unlock();
            }
            return null;
        };
    }

    private List<Callable<Void>> generateJobs() {
        return IntStream.range(0, totalCount)
                .mapToObj(this::generateJob)
                .toList();
    }
}