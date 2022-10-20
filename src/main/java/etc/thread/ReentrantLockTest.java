package etc.thread;

import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

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
                break;
            }
        }
        LocalDateTime endTime = LocalDateTime.now();
        PrintStream var7 = System.out;
        Duration between = Duration.between(startTime, endTime);
        System.out.println(between.getSeconds() + "초");
    }

    private List<Callable<Void>> generateJobs() {
        List<Callable<Void>> jobs = new ArrayList();
        for(int count = 0; count < 15; ++count) {
            jobs.add(() -> {
                lock.lock();
                Thread.sleep(1000L);
                currentCount++;
                lock.unlock();
                return null;
            });
        }
        return jobs;
    }
}