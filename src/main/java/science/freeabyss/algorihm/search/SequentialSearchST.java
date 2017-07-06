package science.freeabyss.algorihm.search;

/**
 * 使用链表实现无序符号表
 * <p>
 * Created by abyss on 06/07/2017.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int size;

    public Value get(Key key) {

        for (Node x = first; x != null; x = x.next) {
            if (x.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            return;
        }
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

    public boolean isEmpty() {
        return size == 0;
    }

    public void delete(Key key) {
        if (key == null) return;

        if (first.key.equals(key)) {
            first = first.next;
            size--;
            return;
        }
        Node parent = first;
        for (Node x = first.next; x != null; parent = x, x = x.next) {
            if (key.equals(x.key)) {
                parent = x.next;
                size--;
                return;
            }
        }
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

}
