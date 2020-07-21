/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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

 /**
  * 2.两数相加
  */

  //可能不完整
class AddTwoNumbers {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode per = new ListNode(0);
        ListNode cur = per;
        int carry = 0;
        while (l1 != null||l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum > 9 ? 1:0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (carry > 0) cur.next = new ListNode(1); 
        return per.next;
    }

    //逻辑清晰版
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode per = new ListNode(0);
        ListNode cur = per;
        int carry = 0;
        while(l1 != null||l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum > 9 ? 1:0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) cur.next = new ListNode(1); 
        return per.next;
    }
}
// @lc code=end

