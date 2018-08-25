/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
* 两链表的第一共同节点
* @author Guozhu Zhu
* @date 2018/8/26
* @version 1.0
*
*/
public class Solution {
    
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
          ListNode first = pHead1;
          ListNode second = pHead2;
          while (first != second) {
              first = first == null ? pHead2 : first.next;
              second = second == null ? pHead1 : second.next;
          }
          return first;
    }
    
}
