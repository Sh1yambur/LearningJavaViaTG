package lesson_60_thread.task_4;

import java.util.Objects;
import java.util.concurrent.Callable;

public class CallableThread<R> {
    private final Thread thread;
    private R result;

    public CallableThread(Callable<R> callable) {
        Objects.requireNonNull(callable);

        this.thread = new Thread(() -> {
            try {
                this.result = callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public R startAndGet() throws InterruptedException {
        thread.start();

        return getResult();
    }

    public R getResult() throws InterruptedException {
        while (thread.isAlive()) {}

        return result;
    }

    public void start() {
        thread.start();
    }
}
