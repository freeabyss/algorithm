package science.freeabyss.algorithm.leetcode.isSymmetric;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        reversal(root);

    }

    public boolean isEquanl(TreeNode a, TreeNode b) {

    }

    public void reversal(TreeNode node) {
        if (node == null) {
            return;
        }
        reversal(node.left);
        reversal(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
