package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/9/17
 * Version:0.0.1
 * 133. Clone Graph
 */
public class lc133 {
    class UndirectedGraphNode {
     int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
    private Map<UndirectedGraphNode, UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        clone(newNode, node);
        return newNode;
    }

    private void clone(UndirectedGraphNode newNode, UndirectedGraphNode node) {
        int length = node.neighbors.size();
        for (int i = 0; i < length; i++) {
            UndirectedGraphNode temp = node.neighbors.get(i);
            UndirectedGraphNode temp2 = null;
            if (!map.containsKey(temp)) {
                temp2 = new UndirectedGraphNode(temp.label);
                map.put(temp, temp2);
                newNode.neighbors.add(temp2);
                clone(temp2, temp);
            } else {
                temp2 = map.get(temp);
                newNode.neighbors.add(temp2);
            }
        }
    }
}
