package lesson_60_thread.task_2;

public class DynamicThreadFiller extends SimpleFiller {

    public DynamicThreadFiller(int height, int width) {
        super(height, width);
    }

    @Override
    public void fill() {
        for (int[] arr : this.array) {
            fillPart(arr);
        }
    }

    private void fillPart(int[] array) {
        int threshold = array.length / 8;

        for (int i = 0; i < array.length; i += threshold) {
            int start = i;
            int end = Math.min(i + threshold, array.length);

            new Thread(() -> {
                for (int j = start; j < end; j++) {
                    array[j] = this.random.nextInt(1,11);
                }
            }).start();
        }
    }
}
