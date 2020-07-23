import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */




class HasCycle {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           val = x;
           next = null;
        }
    }

    /**
     * 快慢指针法（双指针）
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slower = head;
        ListNode faster = head.next;
        while(faster != slower) {
            if (faster == null || faster.next == null) return false;
            faster = faster.next.next;
            slower = slower.next;
        }
        return true;
        
    }

    /**
     * HashSet法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;       
    }
}
// @lc code=end

