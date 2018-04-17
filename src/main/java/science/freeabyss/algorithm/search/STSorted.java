package science.freeabyss.algorithm.search;

/**
 * 一种有序的泛型符号表的API
 * Created by abyss on 11/09/2017.
 */
public interface STSorted<Key extends Comparable<Key>, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Key min();

    Key max();

    /**
     * 小于等于Key的最大键
     */
    Key floor(Key key);

    /**
     * 大于等于Key 的最小键
     */
    Key ceiling(Key key);

    /**
     * 小于Key 的键的数量
     */
    int rank(Key key);

    /**
     * 排名为k的键
     */
    Key select(int k);

    void deleteMin();

    void deleteMax();

    /**
     * [lo...hi]之间键的数量
     */
    int size(Key lo, Key hi);

    /**
     * [lo...hi]之间的键，已排序
     */
    Iterable<Key> keys(Key lo, Key hi);

    /**
     * 已排序
     */
    Iterable<Key> keys();
}
