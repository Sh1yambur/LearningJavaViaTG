package lesson_60_thread.task_2;

public class ThreadFiller extends SimpleFiller {
    public ThreadFiller(int height, int width) {
        super(height, width);
    }

    @Override
    public void fill() {
        for (int[] arr : this.array) {
            new Thread(
                    () -> {
                        for (int i = 0; i < arr.length; i++) {
                            arr[i] = this.random.nextInt(1,11);
                        }
                    }
            ).start();
        }
    }
}
