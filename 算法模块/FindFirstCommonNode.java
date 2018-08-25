/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
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