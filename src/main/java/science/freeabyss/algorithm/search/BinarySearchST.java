package science.freeabyss.algorithm.search;

import science.freeabyss.algorithm.util.io.StdOut;

import java.util.Arrays;

/**
 * 使用有序数组实现的符号表
 * 基于二分查找算法
 * Created by abyss on 14/09/2017.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static int DEFAULT_ARRAY_SIZE = 16; // 默认数组大小
    private static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 16;
    private Key[] keys;
    private Value[] values;
    private int size;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }


    public boolean isEmpty() {
        return size > 0;
    }

    public int size() {
        return size;
    }

    public Value get(Key key) {
        int i = rank(key);

        if (i < size && key.compareTo(keys[i]) == 0) {
            return values[i];
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }
        ensureCapacity(size + 1);
        for (int j = size - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
            values[j + 1] = values[j];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public boolean contains(Key key) {
        int i = rank(key);
        return i < size && keys[i].compareTo(key) == 0;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            for (; i < size - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            size--;
        }
    }

    public Key min() {
        if (!isEmpty()) {
            return keys[0];
        }
        return null;
    }

    public Key max() {
        if (!isEmpty()) {
            return keys[size - 1];
        }
        return null;
    }

    public Key floor(Key key) {
        return null;
    }

    public Key ceiling(Key key) {
        return null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    public Key select(int k) {
        if (k < size) {
            return keys[k];
        }
        return null;
    }

    // 动态扩展数组
    private void ensureCapacity(int minCapacity) {
        if (keys == null || keys.length == 0) {
            minCapacity = Math.max(minCapacity, DEFAULT_ARRAY_SIZE);
        }
        if (minCapacity > keys.length) {
            int oldCapacity = keys.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);

            newCapacity = newCapacity > minCapacity ? newCapacity : minCapacity;
            newCapacity = newCapacity > MAX_ARRAY_SIZE ? MAX_ARRAY_SIZE : newCapacity;

            keys = Arrays.copyOf(keys, newCapacity);
            values = Arrays.copyOf(values, newCapacity);
        }
    }

    /**
     * 返回小于指定key的数量
     *
     * @param key 指定的key
     */
    private int rank(Key key) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int r = key.compareTo(keys[mid]);
            if (r > 0) {
                lo = mid + 1;
            } else if (r < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(16);

        st.put("A", 1);
        System.out.println("put A=1");
        println(st);

        st.put("B", 2);
        System.out.println("put B=2");
        println(st);

        st.put("D", 4);
        System.out.println("put D=4");
        println(st);

        st.put("Z", 1);
        System.out.println("put Z=1");
        println(st);

        st.put("A", 2);
        System.out.println("put A=2");
        println(st);

        st.put("F", 2);
        System.out.println("put F=2");
        println(st);

        st.delete("A");
        System.out.println("delete A");
        println(st);

        System.out.println("get B = " + st.get("B"));
        println(st);

    }

    private static void println(BinarySearchST st) {
        StdOut.print("keys   : ");
        for (int i = 0; i < st.size; i++) {
            System.out.print(st.keys[i] + ", ");
        }
        System.out.println();
        StdOut.print("values : ");
        for (int i = 0; i < st.size; i++) {
            System.out.print(st.values[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }
}
