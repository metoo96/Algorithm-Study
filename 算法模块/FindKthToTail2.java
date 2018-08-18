import java.util.*;

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
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = head;
        int j = 0;
        while (current != null) {
            stack.push(current);
            current = current.next;
            j++;
        }
        if (k > j) {
            return null;
        }
        for (int i = 0; i < k-1; i++) {
            stack.pop();
        }
        return stack.pop();
    }
    
}