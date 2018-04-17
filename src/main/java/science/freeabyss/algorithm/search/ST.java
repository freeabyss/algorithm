package science.freeabyss.algorithm.search;

/**
 * 符号表的API
 * Created by abyss on 11/09/2017.
 */
public interface ST<Key, Value> {
    void put(Key key, Value val);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
