package p32;

/**
 * 链表的中间节点
 * @author Guozhu Zhu
 * @date 2018/8/25
 * @version 1.0
 */
public class Test07 {
	
	public ListNode Solution(ListNode head) {
		 ListNode[] A = new ListNode[1000];
	        int i = 0;
	        while (head.next != null) {
	            A[i++] = head;
	            head = head.next;
	        }
	        return A[i / 2];
	}

}
