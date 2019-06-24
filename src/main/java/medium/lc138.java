package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:maslke
 * Date:2017/8/31
 * Version:0.0.1
 */
public class lc138 {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            label = x;
        }
    }
    private Map<RandomListNode, RandomListNode> map;
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode temp = new RandomListNode(1);
        copy(temp, head);
        return temp.next;
    }

    private void copy(RandomListNode prev, RandomListNode node){
        RandomListNode newNode = new RandomListNode(node.label);
        prev.next = newNode;
        if (node.random != null) {
            if (map.containsKey(node.random)) {
                newNode.random = map.get(node.random);
            } else {
                RandomListNode random = new RandomListNode(node.random.label);
                newNode.random = random;
                map.put(node.random, random);
            }
        }
        if (node.next != null) {
            if (map.containsKey(node.next)) {
                newNode.next = map.get(node.next);
            } else {
                RandomListNode next = new RandomListNode(node.next.label);
                newNode.next = next;
                map.put(node.next, next);
            }
            copy(newNode, node.next);
        }
    }

    // recursive
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);
        RandomListNode h = new RandomListNode(head.label);
        map.put(head, h);
        h.next = copyRandomList(head.next);
        h.random = copyRandomList(head.random);
        return h;
    }
}
    