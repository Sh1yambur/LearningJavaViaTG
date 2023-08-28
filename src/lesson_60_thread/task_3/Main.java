package lesson_60_thread.task_3;

// Реализовать распараллеливание вычислений и получение их значений из разных потоков (Callable)

// (*) решение из разбора
public class Main {
    public static void main(String[] args) throws InterruptedException {
        var callableThread = new CallableThread<>(() -> Thread.currentThread().getName());
        callableThread.start();
        System.out.println(callableThread.getResult());

        callableThread = new CallableThread<>(() -> Thread.currentThread().getName());
        System.out.println(callableThread.startAndGet());
    }
}
