package medium;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


//https://leetcode.com/problems/linked-list-components/
//817. Linked List Components
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public int numComponents(ListNode head, int[] G) {
        if (G.length == 0) return 0;
        if (G.length == 1) return 1;
        int length = 0;
        ListNode temp = head;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while (temp != null) {
            map.put(temp.val, index++);
            temp = temp.next;
        }
        int len = G.length;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = map.get(G[i]);
        }
        Arrays.sort(ret);
        int count = 0;
        int inx = 1;
        while (inx < len) {
            while (inx < len && ret[inx] - ret[inx - 1] == 1) {
                inx++;
            }
            count++;
            inx++;
        }
        if (ret[len - 1] - ret[len - 2] == 1) return count;
        return count + 1;
    }
}