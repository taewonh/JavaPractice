package etc.concurrent.forkjoin;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ForkJoinTask 구현체 테스트")
public class ForkJoinSubTaskTest {

    @Test
    @DisplayName("반환값이 존재하지 않는 RecursiveAction Fork 테스트")
    public void testRecursiveAction(){

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(128);
        forkJoinPool.invoke(myRecursiveAction);

        //Just wait until all tasks done
        try {
            forkJoinPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyRecursiveAction extends RecursiveAction {

        private final long workLoad;

        public MyRecursiveAction(long workLoad) {
            this.workLoad = workLoad;
        }

        @Override
        protected void compute() {

            if (this.workLoad > 16) {
                printThreadInfo("split");
                sleep();
                forkSubTasks();
            } else {
                printThreadInfo("myself");
            }
        }

        private void printThreadInfo(String runner) {
            String threadName = Thread.currentThread().getName();
            System.out.println("[" + LocalTime.now() + "][" + threadName + "][" + runner + "][" + this.workLoad + "]");
        }

        private void forkSubTasks() {
            List<MyRecursiveAction> tasks = new ArrayList<>(Arrays.asList(
                    new MyRecursiveAction(this.workLoad / 2),
                    new MyRecursiveAction(this.workLoad / 2)
            ));
            tasks.forEach(ForkJoinTask::fork);
        }

        private void sleep() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("반환값이 존재하는 RecursiveTask Fork & Join 테스트")
    public void testRecursiveTask(){

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
        Long result = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("RecursiveTask Join Merge Result : " + result);

        //Just wait until all tasks done
        try {
            forkJoinPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyRecursiveTask extends RecursiveTask<Long> {

        private final long workLoad;

        private MyRecursiveTask(long workLoad) {
            this.workLoad = workLoad;
        }

        @Override
        protected Long compute() {
            if (this.workLoad > 16) {
                printThreadInfo("split");
                sleep();
                return forkJoinSubTask();
            } else {
                printThreadInfo("myself");
                sleep();
                return workLoad * 3;
            }
        }

        private Long forkJoinSubTask() {
            List<MyRecursiveTask> tasks = new ArrayList<>(Arrays.asList(
                    new MyRecursiveTask(this.workLoad / 2),
                    new MyRecursiveTask(this.workLoad / 2)
            ));
            for (MyRecursiveTask task : tasks) {
                task.fork();
            }
            long result = 0;
            for (MyRecursiveTask task : tasks) {
                result += task.join();
                printThreadInfo("received");
            }
            return result;
        }

        private void printThreadInfo(String runner) {
            String threadName = Thread.currentThread().getName();
            System.out.println("[" + LocalTime.now() + "][" + threadName + "][" + runner + "][" + this.workLoad + "]");
        }

        private void sleep() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
