import java.util.*;
// @lc code=start
/* *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 445.两数相加-ii
 */
class AddTwoNumzbersII {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        
    }

    /**
     * 因为加法运算是{@code 低位到高位}计算的，依旧是需要逆链表计算，所以根据栈{@code 先进后出}的特性
     * 采用栈来计算，并采用{@code 头插法}对结果链表进行逆序操作
     * @param l1
     * @param l2
     * @return 
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer>stack1 = new Stack<>();
        Stack<Integer>stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;//记录进位
        ListNode result = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {

			int m = stack1.isEmpty() ? 0 : stack1.pop();
			int n = stack2.isEmpty() ? 0 : stack2.pop();

			int sum = m + n + carry;
			carry = sum > 9 ? 1 : 0;
			sum = sum % 10;

			// 链表头插法 注意前面链头定义为null
			ListNode temp = new ListNode(sum);
			//这个时候temp已经变成了链表头，高位在前，低位在后。
			temp.next = result;
			//由于temp是临时变量，不能返回，我们用resutl代替temp，作为链表头
			//此时，依然是高位在前，低位在后。
			result = temp;
		}
		return result;
    }
}
// @lc code=end

