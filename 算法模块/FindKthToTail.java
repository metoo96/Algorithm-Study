/**
* 链表中倒数第k个节点
* @author Guozhu Zhu
* @date 2018/8/18
* @version 1.0
*
*/
public class Solution {
    
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        //先走k-1步
        int i = 0;
        while (i < k-1) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
            i++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    
}
