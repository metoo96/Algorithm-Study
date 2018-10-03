import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Palindrome {
    
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果是奇数个节点，就跳过中间节点
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