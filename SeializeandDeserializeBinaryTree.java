/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString().trim();
    }

    public void helper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(" ");
            return;
        }

        sb.append(node.val).append(" ");
        helper(node.left, sb);
        helper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(" ")));

        return deserializeHelper(q);
    }

    public TreeNode deserializeHelper(Queue<String> q) {
        String s = q.poll();
        if (s.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));