import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
* 判断是否为回文链表(快慢指针+栈)
* @author Guozhu Zhu
* @date 2018/10/3
* @version 1.0
*
*/
public class Palindrome {
    
    public boolean isPalindrome(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果是链表是奇数个节点，就跳过中间节点的比较
        if (fast != null) {
            slow = slow.next;
        }
        while (slow.next != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    
}
