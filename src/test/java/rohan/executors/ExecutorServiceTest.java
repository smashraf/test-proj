package rohan.executors;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.junit.Test;

public class ExecutorServiceTest {

    //private ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo(Executors.newFixedThreadPool(15));
    
    //Using a synchronous executor service implementation
    private ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo(new MySynchronousExecutorService());
    
    @Test
    public void sortInChunksTest() throws InterruptedException, ExecutionException {
        int [] arr = new int[80];
        for(int i=0;i<80;i++) {
            arr[i] = ((int)(Math.random()*1000));
        }
        executorServiceDemo.sortChunks(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    
        
}
