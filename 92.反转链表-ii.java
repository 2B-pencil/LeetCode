/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseLinkedList {

    public static void main(String[] args) {
        
    }
    
    /**
     * 翻转整个链表
     * @param head
     * @return
     */
    public ListNode reverseWhole(ListNode head) {
        if (head == null) return head;
        ListNode res = reverseWhole(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    ListNode successor = null;
    /**
     * 翻转链表的前{@code n}个节点,如果总结点少于{@code n}则翻转整个链表
     * @param head
     * @return
     */
    public ListNode reverseForward(ListNode head, int n) {
        if(head==null || head.next==null)  return head;
        if (n == 1) { 
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseForward(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseForward(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
// @lc code=end

