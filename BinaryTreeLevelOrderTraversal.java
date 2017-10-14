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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }

    public void helper(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) {
            return;
        }

        if (level == list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);

        helper(node.left, list, level + 1);
        helper(node.right, list, level + 1);
    }
}