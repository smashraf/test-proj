package rohan.executors;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;

public class ExecutorServiceDemo {

    private ExecutorService executorService;

    public ExecutorServiceDemo(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void sortChunks(int[] arr) {
        // int chunkSize = 20;
        int noChunks = (arr.length / 20) % 2 == 0 ? arr.length / 20 : arr.length / 20 + 1;
        for (int i = 0; i < noChunks; i++) {
            executorService.submit(new Task(i * 20, i * 20 + 20, arr));
        }
    }

    public class Task implements Runnable {

        public Task(int start, int end, int[] arr) {
            this.start = start;
            this.end = end;
            this.arr = arr;
        }

        public int start;

        public int end;

        public int[] arr;

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Arrays.sort(arr, start, end);
        }

    }
}
