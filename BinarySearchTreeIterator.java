/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode node;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        node = stack.pop();
        int rst = node.val;
        node = node.right;

        return rst;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */