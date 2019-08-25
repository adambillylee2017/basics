import java.util.*;

/**
 * Created by adamli on 6/19/16.
 */
public class CloneGraphBFS {
    /**
     * there are two operations in deep copying a node
     * 1. copy node and add mapping between original and copied node
     * 2. recover neighbours in the new node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

        // for each new node in the graph, copy and establish mapping before pushing to queue
        UndirectedGraphNode head = copyAndEstablishMapping(visited, node);
        queue.offer(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();

            /**
             * for all neighbour nodes, copy and establish mapping before pushing to queue
             */
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                /**
                 * if current neighbor is not copied yet, add it into the queue TO COPY ITS NEIGHBORS
                 */
                if (!visited.containsKey(neighbor)) {
                    // copy CURRENT NEIGHBOUR
                    copyAndEstablishMapping(visited, neighbor);

                    // add it into the queue TO COPY ITS NEIGHBORS
                    queue.add(neighbor);
                }

                /**
                 * the mapping for copied neighbour node has to exist in order to recover
                 * neighbours in the new node
                 */
                visited.get(curr)
                        .neighbors
                        .add(visited.get(neighbor));
            }
        }

        return head;
    }

    private UndirectedGraphNode copyAndEstablishMapping(Map<UndirectedGraphNode, UndirectedGraphNode> visited, UndirectedGraphNode neighbor) {
        UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
        visited.put(neighbor, tmp);
        return tmp;
    }
}
