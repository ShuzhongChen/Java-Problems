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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        TreeNode prev = null;

        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }

            curt = stack.pop();

            if (prev != null && prev.val >= curt.val) {
                return false;
            }

            prev = curt;
            curt = curt.right;
        }

        return true;
    }
}