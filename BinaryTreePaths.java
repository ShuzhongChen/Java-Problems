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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        String s = "";
        helper(list, root, s);
        return list;
    }

    public void helper(List<String> list, TreeNode node, String s) {
        s = s + node.val;

        if (node.left == null && node.right == null) {
            list.add(s);
            return;
        }

        s = s + "->";

        if (node.left != null) {
            helper(list, node.left, s);
        }

        if (node.right != null) {
            helper(list, node.right, s);
        }
    }
}