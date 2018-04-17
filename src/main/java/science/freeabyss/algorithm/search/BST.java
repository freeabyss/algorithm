package science.freeabyss.algorithm.search;

/**
 * 二叉查找树
 * Created by abyss on 14/09/2017.
 */
public class BST<Key extends Comparable, Value> {


    private class Node {
        private Node left;
        private Node right;
        private Value value;
        private Key key;
        private int length;

        Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
