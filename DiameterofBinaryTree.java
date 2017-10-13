/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        treeDepth(root);
        return max;
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}