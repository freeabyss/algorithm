package science.freeabyss.algorihm.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用链表实现无序符号表
 * <p>
 * 未命中的查找和插入操作都需要N次比较，命中的查找在最坏的情况下需要N次比较，
 * 想一个空表插入 N个不同的键值对，需要 ~N*N/2次比较。
 * 随机命中的平均比较次数为 ~N/2 次
 * <p>
 * Created by abyss on 06/07/2017.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int size;

    public Value get(Key key) {
        if (key == null) throw new NullPointerException("argument to get() is null");
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new NullPointerException("argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (x.equals(key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        size++;
    }


    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");

        if (first.key.equals(key)) {
            first = first.next;
            size--;
            return;
        }
        Node parent = first;
        for (Node x = first.next; x != null; parent = x, x = x.next) {
            if (key.equals(x.key)) {
                parent.next = x.next;
                size--;
                return;
            }
        }
    }

    public Iterable<Key> keys() {
        return null;
    }

    public int size() {
        return size;
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);

        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        try (FileReader reader = new FileReader(SequentialSearchST.class.getResource("/data/tale.txt").getFile());
             BufferedReader buffer = new BufferedReader(reader)) {
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.length() < minLen) continue;

                    if (!st.contains(w)) {
                        st.put(w, 1);
                    } else {
                        st.put(w, st.get(w) + 1);
                    }
                }
            }

            String max = " ";
            st.put(max, 0);

            System.out.println(max + " : " + st.get(max));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
