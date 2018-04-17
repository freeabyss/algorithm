package science.freeabyss.algorithm.leetcode;


/**
 * @author abyss
 * @date 2018/4/13
 */
public class MergeTrees {


    public static TreeNode solution(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int left = t1 == null ? 0 : t1.val;
        int right = t2 == null ? 0 : t2.val;
        TreeNode resultNode = new TreeNode(left + right);
        resultNode.left = solution(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        resultNode.right = solution(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return resultNode;

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
