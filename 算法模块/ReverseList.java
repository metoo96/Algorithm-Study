/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/*
* 翻转链表
* @author Guozhu Zhu
* @date 2018/8/10
* @version 1.0
*/
public class Solution {
    
    public ListNode ReverseList(ListNode head) {
    ListNode pre = null;
    ListNode next = null;
    while (head != null) {
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
    }
    return pre;
    }
    
}
