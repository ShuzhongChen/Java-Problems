/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);

        queue.add(node);
        set.add(node);
        map.put(node, copyNode);

        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            UndirectedGraphNode copy = map.get(tmp);

            for (int i = 0; i < tmp.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = tmp.neighbors.get(i);

                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }

                copy.neighbors.add(map.get(neighbor));
            }
        }

        return copyNode;
    }
}