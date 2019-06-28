package medium;

import java.util.Map;
import java.util.HashMap;
 import java.util.Stack;

// https://leetcode.com/problems/next-greater-node-in-linked-list/
// 1019. Next Greater Node In Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 
 class lc1019 {
    
    class Pair {
        int index;
        ListNode node;
        
        Pair(int index, ListNode node) {
            this.index = index;
            this.node = node;
        }
    }
    
    public int[] nextLargerNodes(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Pair> stack = new Stack<>();
        int len = 0;

        ListNode temp = head;
        while (temp != null) {

            while (!stack.isEmpty() && stack.peek().node.val < temp.val) {
                Pair p = stack.pop();
                map.put(p.index, temp.val);
            }

            stack.push(new Pair(len, temp));
            len++;
            temp = temp.next;
        }

        int[] result = new int[len];
        for (Integer key : map.keySet()) {
            result[key] = map.get(key);
        }

        return result;
    }
 }