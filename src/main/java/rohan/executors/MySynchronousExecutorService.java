package rohan.executors;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

public class MySynchronousExecutorService extends AbstractExecutorService {

    private boolean terminated;

    @Override
    public void shutdown() {
        terminated = true;
    }

    @Override
    public List<Runnable> shutdownNow() {
        terminated = true;
        return Collections.emptyList();
    }

    @Override
    public boolean isShutdown() {
        terminated = true;
        return terminated;
    }

    @Override
    public boolean isTerminated() {
        return terminated;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return true;
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }

}
