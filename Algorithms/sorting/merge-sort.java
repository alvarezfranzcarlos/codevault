import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class MergeSort<T> extends RecursiveTask<T[]> {
    private final T[] array;
    private final Comparator<T> comparator;

    public MergeSort(T[] array, Comparator<T> comparator) {
        this.array = array;
        this.comparator = comparator;
    }

    @Override
    protected T[] compute() {
        if (array.length < 2) {
            return array;
        }

        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        MergeSort<T> leftTask = new MergeSort<>(left, comparator);
        MergeSort<T> rightTask = new MergeSort<>(right, comparator);

        invokeAll(leftTask, rightTask);

        return merge(leftTask.join(), rightTask.join());
    }

    private T[] merge(T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        T[] merged = Arrays.copyOf(array, array.length);

        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }
        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        Integer[] numbers = { 64, 34, 25, 12, 22, 11, 90 };
        MergeSort<Integer> task = new MergeSort<>(numbers, Integer::compare);
        ForkJoinPool pool = new ForkJoinPool();
        Integer[] sortedArray = pool.invoke(task);

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}
