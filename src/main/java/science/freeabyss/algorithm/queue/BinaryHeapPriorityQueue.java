package science.freeabyss.algorithm.queue;

import java.util.Arrays;

/**
 * 基于二叉堆的优先队列
 * 对于含有N个元素的基于堆的优先队列，
 * 插入元素操作只需要不超过 lgN+1 次操作
 * 删除最大元素操作，只需要不超过 2lgN次操作
 * Created by abyss on 22/08/2017.
 */
public class BinaryHeapPriorityQueue<K extends Comparable<K>> {
    private K[] queue;
    private int size;
    private K[] DEFAULT_EMPTY_ARRAY = (K[]) new Comparable[]{};
    private int DEFAULT_ARRAY_SIZE = 17;
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public BinaryHeapPriorityQueue(int length) {
        queue = (K[]) new Comparable[length];
    }

    public void insert(K v) {
        ensureCapacity(size + 2);
        queue[++size] = v;
        swim(size);
    }

    public K max() {
        return queue[1];
    }

    public K delMax() {
        K max = queue[1];
        exch(1, size--);
        queue[size + 1] = null;
        sink(1);

        if (size <= queue.length / 2) {
            trimToSize();
        }
        return max;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void exch(int i, int j) {
        K t = queue[i];
        queue[i] = queue[j];
        queue[j] = t;
    }

    private boolean less(int i, int j) {
        return queue[i].compareTo(queue[j]) < 0;
    }

    // 由下而上的堆有序化
    private void swim(int i) {
        while (i > 1 && less(i / 2, i)) {
            exch(i / 2, i);
            i = i / 2;
        }
    }

    // 由上而下的堆有序化
    private void sink(int i) {
        while (i * 2 <= size) {
            int j = i * 2;
            if (j < size && less(j, j + 1)) j++;
            if (!less(i, j)) break;
            exch(i, j);
            i = j;
        }
    }

    private void trimToSize() {
        if (size < queue.length) {
            queue = size == 0
                    ? DEFAULT_EMPTY_ARRAY
                    : Arrays.copyOf(queue, size);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (queue == DEFAULT_EMPTY_ARRAY) {
            minCapacity = Math.max(minCapacity, DEFAULT_ARRAY_SIZE);
        }
        ensureCapacityInternal(minCapacity);
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (minCapacity - queue.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        newCapacity = Math.max(minCapacity, newCapacity);
        newCapacity = Math.max(newCapacity, MAX_ARRAY_SIZE);

        queue = Arrays.copyOf(queue, newCapacity);
    }
}
