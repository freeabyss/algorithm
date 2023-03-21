package science.freeabyss.algorithm.leetcode.buildTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?favorite=2cktkvj
 */
class Solution {

    Map<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
//        new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        new Solution().buildTree(new int[]{1, 2}, new int[]{2, 1});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree1(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree1(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        if (preEnd - preStart == 1) {
            return treeNode;
        }
        //先寻找inorder中根节点的位置， 左节点的数量，等于中序遍历中根节点的索引
        int inRootIndex = indexMap.get(preorder[preStart]);

        int leftNum = inRootIndex - preStart;

        int preLeftStart = preStart + 1;
        int preLeftEnd = preLeftStart + leftNum;
        if (leftNum > 0) {
            treeNode.left = buildTree1(preorder, preStart + 1, preLeftEnd, inorder, inStart, inRootIndex);
        }
        if (inRootIndex < inEnd - 1) {
            treeNode.right = buildTree1(preorder, preLeftEnd, preEnd, inorder, inRootIndex + 1, inEnd);
        }
        return treeNode;
    }


    public static class TreeNode {
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