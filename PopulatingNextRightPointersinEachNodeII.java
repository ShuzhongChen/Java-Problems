/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {

        TreeLinkNode next = null;

        while (root != null) {
            TreeLinkNode prev = null;

            while (root != null) {

                if (root.left != null) {
                    if (prev != null) {
                        prev.next = root.left;
                        prev = root.left;
                    } else {
                        prev = root.left;
                        if (next == null) {
                            next = root.left;
                        }
                    }
                }

                if (root.right != null) {
                    if (prev != null) {
                        prev.next = root.right;
                        prev = root.right;
                    } else {
                        prev = root.right;
                        if (next == null) {
                            next = root.right;
                        }
                    }
                }

                root = root.next;
            }

            root = next;
            next = null;
        }
    }
}